package com.mayi.contant;

public interface Constants {

    // 响应code
    String HTTP_RES_CODE_NAME = "code";
    // 响应msg
    String HTTP_RES_CODE_MSG = "msg";
    // 响应data
    String HTTP_RES_CODE_DATA = "data";
    // 响应请求成功
    String HTTP_RES_CODE_200_VALUE = "success";
    // 系统错误
    String HTTP_RES_CODE_500_VALUE = "fial";
    // 响应请求成功code
    Integer HTTP_RES_CODE_200 = 200;
    // 系统错误
    Integer HTTP_RES_CODE_500 = 500;

    // 发送邮件
    String MSG_EMAIL ="email";
    // 会员token
    String TOKEN_MEMBER ="TOKEN_MEMBER";

    // 用户有效期 90天
    Long TOKEN_MEMBER_TIME =(long) (60*60*24*90);
    int COOKIE_TOKEN_MEMBER_TIME =(60*60*24*90);
    // cookie 会员 totoken 名称
    String COOKIE_MEMBER_TOKEN ="cookie_member_token";

}
