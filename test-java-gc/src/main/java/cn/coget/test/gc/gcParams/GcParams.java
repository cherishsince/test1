package cn.coget.test.gc.gcParams;

/**
 * author: sin
 * time: 2021/2/25 1:16 下午
 */
public class GcParams {

    public static void main(String[] args) {
        // 100W 日活用户
        int a1 = 1000000;
        // 用户模块，每个用户2次请求 200W
        int a2 = a1 * 2;
        // 用户每次产生的请求为 1kb
        int a3 = a2 * 1;
        // 其他请求额外因素，扩大 2 倍
        int a4 = a3 * 2;
        // 转换分钟
        double a5 = a4 / (24 * 60 * 60);
        System.err.println("每秒钟产生的GC：" + a5 + " MB");
        // 10台机器来处理
        int a6 = (int)(a5 / 10);
        System.err.println("每台机器，每秒钟处理" + a6 + " 次请求");


        System.err.println("400W: " + 4000000 / 1024 / 1024 + " GB");
        System.err.println("400W: " + 8000000 / 1024 / 1024 + " GB");
    }
}
