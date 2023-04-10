package org.example.base;

//内部类

public class InnerClass {
    int i = 0;
    static int j = 1;
    //静态内部类
    static class StaticInnerClass {
        void method() {
            System.out.println("StaticInnerClass method" + j);
        }
        static void staticMethod() {
            System.out.println("StaticInnerClass staticMethod" + j);
        }
    }

    //成员内部类
    class MemberInnerClass{
        void method(){
            System.out.println("MemberInnerClass" + i + j);
        }
    }

    //局部内部类
    void createPartInnerClass(){
        class PartInnerClass{
            void method(){
                System.out.println("PartInnerClass" + i + j);
            }
        }

        PartInnerClass partInnerClass = new PartInnerClass();
        partInnerClass.method();
    }

    //匿名内部类 接口方式
    void createAnonymousInnerByInterfaceClass(){
        AnonymousInnerInterface anonymousInnerInterface = new AnonymousInnerInterface() {
            @Override
            public void method() {
                System.out.println("AnonymousInnerClass" + i + j);
            }
        };
        anonymousInnerInterface.method();
    }
    interface AnonymousInnerInterface{
        void method();
    }

    //匿名内部类 抽象方式
    void createAbstractAnonymousInnerClass(){
        AbstractAnonymousInnerClass abstractAnonymousInnerClass = new AbstractAnonymousInnerClass() {
            @Override
            void method() {
                System.out.println("AbstractAnonymousInnerClass" + i + j);
            }
        };
        abstractAnonymousInnerClass.method();
    }
    abstract class AbstractAnonymousInnerClass{
        void method(){};
    }
    public static void main(String[] args) {
        InnerClass test = new InnerClass();

        //调用静态内部类
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        staticInnerClass.method();
        StaticInnerClass.staticMethod();

        //调用成员内部类
        MemberInnerClass memberInnerClass = test.new MemberInnerClass();
        memberInnerClass.method();

        //调用局部内部类
        test.createPartInnerClass();

        //调用匿名内部类 接口方式
        test.createAnonymousInnerByInterfaceClass();

        //调用匿名内部类 抽象方式
        test.createAbstractAnonymousInnerClass();

    }

}

