package com.mybatis.sample.sample.configuration.exception;

import com.mybatis.sample.sample.configuration.http.BaseResponseCode;
//custom으로 데이터를 추가할 경우 에러코드 등과 같은 부분을 상황에 맞게 보기 위해..

public abstract class AbstractBaseException extends RuntimeException {

    private static final long serialVersionUID = 8342235231880246631L;

    protected BaseResponseCode responseCode;

    protected Object[] args;

    public AbstractBaseException() {}

    public AbstractBaseException(BaseResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public BaseResponseCode getResponseCode(){
        return responseCode;
    }
    public Object[] getArgs(){
        return args;
    }
}
