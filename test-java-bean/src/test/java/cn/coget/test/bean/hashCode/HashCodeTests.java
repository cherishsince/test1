package cn.coget.test.bean.hashCode;

import cn.coget.test.bean.hashCode.bean.HashCodeBean;
import org.junit.Before;
import org.junit.Test;

/**
 * author: Sin
 * time: 2020/7/13 13:50
 */
public class HashCodeTests {

    @Before
    public void setup() {
    }

    @Test
    public void toStringTest() {
        HashCodeBean hashCodeBean1 = new HashCodeBean("1");
        HashCodeBean hashCodeBean2 = new HashCodeBean("100");
        HashCodeBean hashCodeBean3 = new HashCodeBean("200");
        System.err.println(hashCodeBean1.hashCode());
        System.err.println(hashCodeBean2.hashCode());
        System.err.println(hashCodeBean3.hashCode());
        System.err.println(Integer.toHexString(hashCodeBean1.hashCode()));
        System.err.println(Integer.toHexString(hashCodeBean2.hashCode()));
        System.err.println(Integer.toHexString(hashCodeBean3.hashCode()));

        hashCodeBean1.setName("2");
        System.err.println(hashCodeBean1.hashCode());
    }
}
