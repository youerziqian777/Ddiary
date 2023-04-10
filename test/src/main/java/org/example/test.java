package org.example;

final class A{
    int x = 1;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
public class Test {
    public static void main(String[] args) {
        A a = new A();
        A b = new A();
        System.out.println(a.getX());
        a.setX(5);
        a = b;
        System.out.println(a.getX());
    }

}

