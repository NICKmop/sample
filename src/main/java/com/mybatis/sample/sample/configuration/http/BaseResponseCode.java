package com.mybatis.sample.sample.configuration.http;

public enum BaseResponseCode {

    SUCCESS,
    ERROR,
    DATA_IS_NULL, // NULL 체크
    VALIDATE_REQUIRED, // 필수 체크
    ;
//
//    private int status;
//
//    BaseResponseCode(int status){
//        this.status = status;
//    }
//
//    public int status(){
//        return status;
//    }
}
