package cn.coget.test.bean.serializable;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Java序列化的目的主要有两个：
 *
 * 1.网络传输
 *
 * 2.对象持久化
 *
 * author: Sin
 * time: 2020/7/15 14:35
 */
public class SerializableTests {

    String path = null;
    UserObject userObject = null;

    @Before
    public void setup() {
        userObject = new UserObject("小明", 23);
        path = SerializableTests.class.getResource("/").getPath() + "" + SerializableTests.class.getSimpleName() + ".ser";
    }

    @Test
    public void writeTest() throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path));
        outputStream.writeObject(userObject);
        System.err.println("Serializable success.");
    }

    @Test
    public void readTest() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        UserObject readObject = (UserObject) inputStream.readObject();
        System.err.println("Read serializable success." + readObject);
    }


    @Test
    public void readByteTest() throws IOException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        byte[] buffer = new byte[1024];
        int size = inputStream.read(buffer);
        System.err.println("Read serializable success. " + size);
    }
}
