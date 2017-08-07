package com.doraemon.base.protocol.http;

import com.doraemon.base.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zbs on 2017/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class SpingHttpTest {

    @Autowired
    SpingHttp spingHttp;

    @Test
    public void http() throws Exception {
        spingHttp.request();
    }
}
