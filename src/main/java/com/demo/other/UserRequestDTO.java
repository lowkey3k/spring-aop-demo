package com.demo.other;

import cn.hutool.json.JSONObject;
import lombok.Builder;

/**
 * @author LiHaitao
 * @description UserRequestDTO:
 * @date 2019/12/17 14:57
 **/
@Builder
public class UserRequestDTO extends JSONObject {


    public UserRequestDTO account(String account) {
        super.put("account", account);
        return this;
    }

    public UserRequestDTO pwd(String pwd) {
        super.put("pwd", pwd);
        return this;
    }

    public UserRequestDTO userName(String userName) {
        super.put("userName", userName);
        return this;
    }

    public UserRequestDTO idcard(String idcard) {
        super.put("idcard", idcard);
        return this;
    }

    public UserRequestDTO num(String num) {
        super.put("num", num);
        return this;
    }

    public UserRequestDTO mobile(String mobile) {
        super.put("mobile", mobile);
        return this;
    }

}
