package com.example.demo.entity.dto;

import lombok.Data;

@Data
public class CommonRespDTO<T> {

    private int code;

    private String msg;

    private T data;

    public CommonRespDTO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonRespDTO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static CommonRespDTO success(){
        return new CommonRespDTO(200,"ok");
    }

    public static<T> CommonRespDTO success(T data){
        return new CommonRespDTO(200,"ok", data);

    }

    public static CommonRespDTO error(){
        return new CommonRespDTO(500,"error");
    }

    public static CommonRespDTO errorWithMessage(String message){
        return new CommonRespDTO(500,message);
    }
}
