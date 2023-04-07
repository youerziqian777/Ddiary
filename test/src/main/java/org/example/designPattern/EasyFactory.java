package org.example.designPattern;

/**
 * @Description 简单工厂
 * @Date 2023/3/10 22:48
 **/
public class EasyFactory {
	public static void main(String[] args) {
		//生产华为手机
		EasyFactoryFactory huaWeiFactory = new EasyFactoryHuaWeiFactory();
		EasyFactoryPhone phone = huaWeiFactory.createPhone();
		phone.print();
		//生产苹果手机
		EasyFactoryFactory iPhoneFactory = new EasyFactoryIPhoneFactory();
		EasyFactoryPhone iPhone = iPhoneFactory.createPhone();
		iPhone.print();
	}
}
interface EasyFactoryPhone{
	void print();
}
class EasyFactoryHuaWeiPhone implements EasyFactoryPhone{
	@Override
	public void print() {
		System.out.println("生产了华为手机");
	}
}
class EasyFactoryIPhone implements EasyFactoryPhone{
	@Override
	public void print() {
		System.out.println("生产了苹果手机");
	}
}
interface EasyFactoryFactory{
	EasyFactoryPhone createPhone();
}
class EasyFactoryHuaWeiFactory implements EasyFactoryFactory{
	@Override
	public EasyFactoryPhone createPhone() {
		return new EasyFactoryHuaWeiPhone();
	}
}
class EasyFactoryIPhoneFactory implements EasyFactoryFactory{
	@Override
	public EasyFactoryPhone createPhone() {
		return new EasyFactoryIPhone();
	}
}
