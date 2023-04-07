package org.example.thread;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * 给定一个整数数组 nums，找到其中两个数满足它们相加之和等于目标数 target，返回这两个数的下标。 例如，给定 nums = [2, 7, 11,15]，target = 9，
 * 因为 nums[0] + nums[1] = 2 + 7 = 9，所以返回 [0, 1]。 请使用多线程的方式实现这个问题的解决方案。
 * @Date 2023/3/5
 * 16:13
 */
public class SimpleThreadTest {
  static List resultList = new ArrayList();
  static int target = 9;
  static class AddNum implements Runnable{
      int i;
      int j;
      AddNum(int i,int j){
          this.i = i;
          this.j = j;
      }
      @Override
      public void run() {
      System.out.println("当前值[" + i + "," + j + "]在" + Thread.currentThread().getName());
          if((i + j) == target){
              resultList.add(new int[]{i,j});
          }
      }
  }
  public static void main(String[] args) {
    int[] nums = {2,7,11,15,1,8};
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    for (int i = 0;i<nums.length;i++){
        for(int j = i + 1;j<nums.length;j++){
            Runnable task = new AddNum(nums[i],nums[j]);
            executorService.execute(task);
        }
    }
    executorService.shutdown();
    System.out.println(JSON.toJSONString(resultList));
  }
}
