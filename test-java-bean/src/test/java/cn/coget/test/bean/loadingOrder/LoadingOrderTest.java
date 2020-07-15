package cn.coget.test.bean.loadingOrder;

/**
 * author: Sin
 * time: 2020/7/15 15:30
 */
public class LoadingOrderTest {

    public static void main(String[] args) {
        System.out.println("\n");
        A ab = new B();
        ab = new B();
        System.out.println("\n");
    }
}


class A {
    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
    }
}

class B extends A {
    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
    }
}