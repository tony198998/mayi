package com.mayi.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.mayi.api.service.TestApiService;
import com.mayi.base.BaseApiService;
import com.mayi.base.ResponseBase;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class TestApiServiceImpl extends BaseApiService implements TestApiService {

    private static String keyd = "node";

    @Override
    public ResponseBase testResponse() {
        return super.setResultSuccess();
    }

    @Override
    public ResponseBase setTestRedis(String key) {
        for (int i = 0; i <10 ; i++) {
            baseRedisService.setString(keyd+i,i+""+"node");
        }
        System.out.println(key);
        Set<String> sets = baseRedisService.getAllRedisKeys(key);
        System.out.println(sets);
        return super.setResultSuccess(sets);
    }

    @Override
    public ResponseBase getRedisValues(String key) {
        System.out.println("--------------key--------"+key);
        Set<String> sets = baseRedisService.getAllRedisKeys(key);
        List result = baseRedisService.getAllValues(sets);
        System.out.println(result);
        return super.setResultSuccess(result);
    }

    @Override
    public Map<String, Object> test(Integer id, String name) {
        Map<String, Object> result = Maps.newHashMap();
        result.put("errorCode","200");
        result.put("msg","success");
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("name",name);
        result.put("data",jsonObject);
        return result;
    }
}
