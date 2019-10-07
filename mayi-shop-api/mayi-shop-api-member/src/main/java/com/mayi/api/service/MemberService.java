package com.mayi.api.service;

import com.mayi.base.ResponseBase;
import com.mayi.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public interface MemberService {

    //根据userid查找用户信息
    @RequestMapping("/findUserById")
    ResponseBase findUserById(Long userId);

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    ResponseBase regUser(@RequestBody UserEntity user);
}
