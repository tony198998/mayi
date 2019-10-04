package com.mayi.base;

import lombok.Data;

@Data
public class ResponseBase {

    private Integer rtnCode;
    private String msg;
    private Object data;

    public ResponseBase() {
    }

    public ResponseBase(Integer rtnCode, String msg, Object data) {
        this.rtnCode = rtnCode;
        this.msg = msg;
        this.data = data;
    }


}
