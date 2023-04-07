package org.example.designPattern;

/**
 * @Description 抽象工厂类
 * @Date 2023/3/10 22:45
 **/

public class AbstractFactory {
	public static void main(String[] args) {
		//生产华为手机
		AbstractFactoryFactory beijingFactory = new AbstractFactoryBeijingFactory();
		AbstractFactoryPhone phone = beijingFactory.createPhone("huawei");
		phone.print();
		//生产时尚口罩
		AbstractFactoryFactory fashionFactory = new AbstractFactoryGuangDongFactory();
		AbstractFactoryMask MaskFashion = fashionFactory.createMask("fashion");
		MaskFashion.print();
	}
}
interface AbstractFactoryPhone{
	void print();
}
class AbstractFactoryHuaWeiPhone implements AbstractFactoryPhone{
	@Override
	public void print() {
		System.out.println("生产了华为手机");
	}
}
class AbstractFactoryIPhone implements AbstractFactoryPhone{
	@Override
	public void print() {
		System.out.println("生产了苹果手机");
	}
}
class AbstractFactoryXiaoMiPhone implements AbstractFactoryPhone{
	@Override
	public void print() {
		System.out.println("生产了小米手机");
	}
}
class AbstractFactoryYiJiaPhone implements AbstractFactoryPhone{
	@Override
	public void print() {
		System.out.println("生产了一加手机");
	}
}
interface AbstractFactoryFactory{
	AbstractFactoryPhone createPhone(String param);
	AbstractFactoryMask createMask(String param);
}
class AbstractFactoryBeijingFactory implements AbstractFactoryFactory{
	@Override
	public AbstractFactoryPhone createPhone(String param) {
		if("huawei".equals(param)){
			return new AbstractFactoryHuaWeiPhone();
		}else if("iphone".equals(param)){
			return new AbstractFactoryIPhone();
		}
		return null;
	}
	@Override
	public AbstractFactoryMask createMask(String param) {
		if("N95".equals(param)){
			return new AbstractFactoryMaskN95();
		}else if("yiCiXing".equals(param)){
			return new AbstractFactoryMaskYiCiXing();
		}
		return null;
	}
}
class AbstractFactoryGuangDongFactory implements AbstractFactoryFactory{
	@Override
	public AbstractFactoryPhone createPhone(String param) {
		if ("xiaomi".equals(param)) {
			return new AbstractFactoryXiaoMiPhone();
		}else if("yijia".equals(param)){
			return new AbstractFactoryYiJiaPhone();
		}
		return null;
	}
	@Override
	public AbstractFactoryMask createMask(String param) {
		if("KN95".equals(param)){
			return new AbstractFactoryMaskKN95();
		}else if("fashion".equals(param)){
			return new AbstractFactoryMaskFashion();
		}
		return null;
	}
}

interface AbstractFactoryMask{
	void print();
}
class AbstractFactoryMaskN95 implements AbstractFactoryMask{
	@Override
	public void print() {
		System.out.println("生产N95口罩");
	}
}
class AbstractFactoryMaskKN95 implements AbstractFactoryMask{
	@Override
	public void print() {
		System.out.println("生产KN95口罩");
	}
}
class AbstractFactoryMaskYiCiXing implements AbstractFactoryMask{
	@Override
	public void print() {
		System.out.println("生产一次性口罩");
	}
}
class AbstractFactoryMaskFashion implements AbstractFactoryMask{
	@Override
	public void print() {
		System.out.println("生产时尚口罩");
	}
}
