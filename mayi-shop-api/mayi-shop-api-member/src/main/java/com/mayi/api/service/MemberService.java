package com.mayi.api.service;

import com.mayi.base.ResponseBase;
import com.mayi.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public interface MemberService {

    //根据userid查找用户信息
    @RequestMapping("/findUserById")
    ResponseBase findUserById(Long userId);

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    ResponseBase regUser(@RequestBody UserEntity user);

    // 用户登录
    @RequestMapping("/login")
    ResponseBase login(@RequestBody UserEntity user);
    // 使用token进行登录
    @RequestMapping("/findByTokenUser")
    ResponseBase findByTokenUser(String token);

    //使用openid查找用户信息
    @RequestMapping("/findByOpenIdUser")
    ResponseBase findByOpenIdUser(@RequestParam("openid") String openid);
    // 用户登录
    @RequestMapping("/qqLogin")
    ResponseBase qqLogin(@RequestBody UserEntity user);
}
