package com.demo.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author LiHaitao
 * @description Test:
 * @date 2019/10/31 19:37
 **/
public class Test {
    /**
     * message xxx {
     * // 字段规则：required -> 字段只能也必须出现 1 次
     * // 字段规则：optional -> 字段可出现 0 次或1次
     * // 字段规则：repeated -> 字段可出现任意多次（包括 0）
     * // 类型：int32、int64、sint32、sint64、string、32-bit ....
     * // 字段编号：0 ~ 536870911（除去 19000 到 19999 之间的数字）
     * 字段规则 类型 名称 = 字段编号;
     * }
     *
     * @param args
     */
    public static void main(String[] args) throws InvalidProtocolBufferException {
        /**
         * 创建.proto文件，定义数据结构
         */
        Message message = new Message();
        message.setLat(12.22);
        message.setLon(23.22);
        message.setMsg("你好！");
        message.setType(1L);
        //序列化message对象，进行传输使用
        byte[] serializer = ProtoBufUtil.serializer(message);
        //通过解析字节，转化为buf对象
        MessageBuf.Message messageBuf = MessageBuf.Message.parseFrom(serializer);
        //再通过buf对象转化成使用对象message
        Message messageNow = new Message();
        messageNow.setType(messageBuf.getType());
        messageNow.setMsg(messageBuf.getMsg());
        messageNow.setLon(messageBuf.getLon());
        messageNow.setLat(messageBuf.getLat());
        System.out.println(messageNow);
        //直接利用protobuf的工具类反序列化
        Message deserializer = ProtoBufUtil.deserializer(serializer, Message.class);
        System.out.println(deserializer);

    }
}
