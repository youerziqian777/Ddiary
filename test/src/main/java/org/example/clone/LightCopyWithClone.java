package org.example.clone;

import com.alibaba.fastjson.JSON;

/**
 * @Description 通过重写object对象的clone()方法实现浅拷贝
 * cloneable接口实际上是没有实现的，它是一个标记接口，标记实现了这个接口的类可以使用object的clone()方法
 * 那么它是如何判断类是否实现了cloneable接口呢？
 * 是因为clone()方法是native，是别的语言实现的，里面有判断
 * @Date 2023/3/6 20:32
 **/
class LightCopyWithCloneGoodsChild{
	private String color;
	private String material;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
}
class LightCopyWithCloneGoods implements Cloneable {
	private String name;
	private double price;

	private LightCopyWithCloneGoodsChild lightCopyWithCloneGoodsChild;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LightCopyWithCloneGoodsChild getLightCopyWithCloneGoodsChild() {
		return lightCopyWithCloneGoodsChild;
	}

	public void setLightCopyWithCloneGoodsChild(LightCopyWithCloneGoodsChild lightCopyWithCloneGoodsChild) {
		this.lightCopyWithCloneGoodsChild = lightCopyWithCloneGoodsChild;
	}

	// 重写clone()方法，并将访问修饰符改为public
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 调用父类的clone()方法
		return super.clone();
	}
}

public class LightCopyWithClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		// 创建一个Goods对象
		LightCopyWithCloneGoods book = new LightCopyWithCloneGoods();
		book.setName("Java编程思想");
		book.setPrice(99.0);
		LightCopyWithCloneGoodsChild lightCopyWithCloneGoodsChild = new LightCopyWithCloneGoodsChild();
		lightCopyWithCloneGoodsChild.setColor("红");
		lightCopyWithCloneGoodsChild.setMaterial("牛皮");
		book.setLightCopyWithCloneGoodsChild(lightCopyWithCloneGoodsChild);
		System.out.println("book: " + book);
		System.out.println("book.lightCopyWithCloneGoodsChild: " + book.getLightCopyWithCloneGoodsChild());
		System.out.println("book: " + JSON.toJSONString(book));

		// 使用clone()方法来浅拷贝book对象
		LightCopyWithCloneGoods copyBook = (LightCopyWithCloneGoods) book.clone();
		System.out.println("copyBook: " + copyBook);
		System.out.println("copyBook.lightCopyWithCloneGoodsChild: " + copyBook.getLightCopyWithCloneGoodsChild());
		System.out.println("copyBook: " + JSON.toJSONString(copyBook));

		// 修改book对象的属性
		book.setName("Effective Java");
		book.setPrice(79.0);
		book.getLightCopyWithCloneGoodsChild().setColor("蓝色");

		// 查看copyBook是否受到影响
		System.out.println("copyBook after modifying book: " + copyBook);
		System.out.println("copyBook.getLightCopyWithCloneGoodsChild after modifying book: " + copyBook.getLightCopyWithCloneGoodsChild());
		System.out.println("copyBook after modifying book: " + JSON.toJSONString(copyBook));

		System.out.println("book.getLightCopyWithCloneGoodsChild after modifying book: " + book.getLightCopyWithCloneGoodsChild());
		System.out.println("book  after modifying book: " + JSON.toJSONString(book));
	}
}
