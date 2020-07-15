package cn.coget.test.bean.localTime;

import org.junit.Test;

import java.time.LocalDateTime;

/**
 * author: Sin
 * time: 2020/7/15 15:44
 */
public class LocalTimeTests {

    @Test
    public void getDayTest() {
        LocalDateTime time = LocalDateTime.now();
        System.err.println(time.minusDays(10).getDayOfMonth());
    }
}
