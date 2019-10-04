package com.mayi.api.service.impl;

import com.mayi.api.service.MemberService;
import com.mayi.base.BaseApiService;
import com.mayi.base.ResponseBase;
import com.mayi.dao.MemberDao;
import com.mayi.entity.UserEntity;
import com.mayi.utils.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@SuppressWarnings("all")
public class MemberServiceImpl extends BaseApiService implements MemberService {

    @Autowired
    private MemberDao memberDao;

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
        return setResultSuccess("用户注册成功.");
    }

    @Override
    public ResponseBase findUserById(Long userId) {
        UserEntity userEntity = memberDao.findByID(userId);
        if (Objects.isNull(userEntity)){
            return setResultError("未找到信息");
        }
        return setResultSuccess(userEntity);
    }


}
