package cn.coget.test.bean.serializable;

import java.io.Serializable;

/**
 * author: Sin
 * time: 2020/7/15 14:34
 */
public class UserObject implements Serializable {

    public static final long serialVersionUID = 1;

    private String username;

    private Integer age;

    @Override
    public String toString() {
        return "UserObject{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public UserObject(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
