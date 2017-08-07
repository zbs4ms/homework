package com.doraemon.trevi.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

/**
 * Created by zbs on 2017/7/3.
 */
@RestController
@RequestMapping("/finance")
@Slf4j
@Api(description = "财务接口")
public class FinanceController {


    @ApiOperation(value = "收入录入")
    @RequestMapping(value = "income", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject income() throws Exception {

    }

    @ApiOperation(value = "开支录入")
    @RequestMapping(value = "income", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject income() throws Exception {

    }
}
