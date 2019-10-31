package com.demo.protobuf;

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
    public static void main(String[] args) {
        /**
         * 创建.proto文件，定义数据结构
         */

    }
}
