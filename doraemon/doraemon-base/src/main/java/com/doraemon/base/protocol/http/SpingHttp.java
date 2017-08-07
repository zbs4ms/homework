package com.doraemon.base.protocol.http;

import feign.Feign;
import feign.Logger;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by zbs on 2017/7/17.
 */
@Configuration
@Log4j
public class SpingHttp {

    public void request() throws UnsupportedEncodingException {
        Bbd bbd = Feign.builder().logLevel(Logger.Level.FULL).target(Bbd.class, "http://dataapi.bbdservice.com");
        String  encodeStr = URLEncoder.encode("贵阳鑫平运输有限公司", "utf-8");
        String s = bbd.ss(encodeStr);
        log.info(s);
    }

}
