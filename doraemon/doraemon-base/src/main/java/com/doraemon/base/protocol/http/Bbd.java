package com.doraemon.base.protocol.http;

import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zbs on 2017/7/17.
 */

@FeignClient
public interface Bbd {

    String appkey = "18hmah3ar3qjr3dvv2b6xmzxampiynzc";

   // @RequestLine("GET /api/bbd_qyxx/?company={company}&appkey=18hmah3ar3qjr3dvv2b6xmzxampiynzc")
    @RequestMapping(value = "/api/bbd_qyxx/?company={company}&appkey=18hmah3ar3qjr3dvv2b6xmzxampiynzc", method = RequestMethod.GET)
    String get(@PathVariable("company") String company);

    @RequestLine("GET /api/bbd_qyxx/?company={company}&appkey=18hmah3ar3qjr3dvv2b6xmzxampiynzc")
    String ss(@Param("company") String company);

}
