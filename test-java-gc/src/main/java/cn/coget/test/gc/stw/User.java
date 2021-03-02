package cn.coget.test.gc.stw;

/**
 * user
 *
 * author: sin
 * time: 2021/2/23 10:51 上午
 */
public class User {

    private String name;

    private String age;

//    @Override
//    protected void finalize() throws Throwable {
////        System.err.println("finalize....");
//        super.finalize();
//    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public User setAge(String age) {
        this.age = age;
        return this;
    }
}
