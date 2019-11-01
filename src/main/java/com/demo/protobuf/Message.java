package com.demo.protobuf;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiHaitao
 * @description Message:
 * @date 2019/11/1 15:40
 **/
@Data
public class Message implements Serializable {

    private String msg; //消息内容
    private Long type; //消息类型
    private double lon; //经度
    private double lat; //纬度
}
