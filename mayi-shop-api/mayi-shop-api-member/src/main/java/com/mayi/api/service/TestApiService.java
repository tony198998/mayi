package com.mayi.api.service;

import com.mayi.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/member/")
public interface TestApiService {

    @RequestMapping("test")
    Map<String, Object>  test(Integer id, String name);

    @RequestMapping("testResponse")
    ResponseBase testResponse();

    @RequestMapping("testRedis")
    ResponseBase setTestRedis(String key);

    @RequestMapping("getRedisValues")
    ResponseBase getRedisValues(String key);

}
