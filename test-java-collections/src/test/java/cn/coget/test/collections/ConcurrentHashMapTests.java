package cn.coget.test.collections;

import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: sin
 * time: 2020/9/3 5:45 下午
 */
public class ConcurrentHashMapTests {

    @Test
    public void putTest() {
        ConcurrentHashMap<User, Integer> data = new ConcurrentHashMap<>();
        for (int i = 0; i < 20000000; i++) {
            data.put(new User("" + i), i);
        }
    }

    public static class User {

        private String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public User setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
