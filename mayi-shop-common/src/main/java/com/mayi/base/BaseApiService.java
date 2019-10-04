package com.mayi.base;

import com.mayi.contant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseApiService {

    @Autowired
    protected BaseRedisService baseRedisService;
    //返回成功
    public  ResponseBase setResultSuccess(){
        return this.setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE,null);
    }

    // 返回成功 ,data可传
    public ResponseBase setResultSuccess(Object data) {
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, data);
    }

    // 返回失败
    public ResponseBase setResultError(String msg){
        return setResult(Constants.HTTP_RES_CODE_500,msg, null);
    }



    //通用封装
    public ResponseBase setResult(Integer code, String msg,Object data){
        return new ResponseBase(code,msg,data);
    }
}
