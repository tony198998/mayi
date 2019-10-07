package com.mayi.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mayi.api.service.MemberService;
import com.mayi.base.BaseApiService;
import com.mayi.base.ResponseBase;
import com.mayi.contant.Constants;
import com.mayi.dao.MemberDao;
import com.mayi.entity.UserEntity;
import com.mayi.mq.RegisterMailboxProducer;
import com.mayi.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@SuppressWarnings("all")
public class MemberServiceImpl extends BaseApiService implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private RegisterMailboxProducer registerMailboxProducer;
    @Value("${messages.queue}")
    private String MESSAGESQUEUE;

    @Override
    public ResponseBase regUser(UserEntity user) {
        // 参数验证
        String password = user.getPassword();
        if (StringUtils.isEmpty(password)) {
            return setResultError("密码不能为空.");
        }
        String newPassword = MD5Util.MD5(password);
        user.setPassword(newPassword);
        Integer result = memberDao.insertUser(user);
        if (result <= 0) {
            return setResultError("注册用户信息失败.");
        }
        // 采用异步方式发送消息
        String email = user.getEmail();
        String json = emailJson(email);
        log.info("####会员服务推送消息到消息服务平台####json:{}", json);
        this.sendMsg(json);
        return super.setResultSuccess("用户注册成功.");
    }

    @Override
    public ResponseBase findUserById(Long userId) {
        UserEntity userEntity = memberDao.findByID(userId);
        if (Objects.isNull(userEntity)){
            return setResultError("未找到信息");
        }
        return setResultSuccess(userEntity);
    }

    private String emailJson(String email) {
        JSONObject rootJson = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("interfaceType", Constants.MSG_EMAIL);
        JSONObject content = new JSONObject();
        content.put("email", email);
        rootJson.put("header", header);
        rootJson.put("content", content);
        return rootJson.toJSONString();
    }

    private void sendMsg(String json) {
        ActiveMQQueue activeMQQueue = new ActiveMQQueue(MESSAGESQUEUE);
        registerMailboxProducer.sendMsg(activeMQQueue, json);

    }


}
