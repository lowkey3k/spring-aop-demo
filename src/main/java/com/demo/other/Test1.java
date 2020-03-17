package com.demo.other;

import cn.hutool.json.JSONUtil;
import com.demo.model.Student;
import com.google.common.collect.Lists;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.function.Function;

/**
 * @author LiHaitao
 * @description Test1:
 * @date 2019/12/17 9:02
 **/
public class Test1 {
    public static void main(String[] args) {
        List<User> users = Lists.newArrayList();
        users.add(new User("lihaitao", 12));

        User[] users1 = new User[1];
        users1[0] = new User("sdf", 12);
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("archiveFileList", users);

        final ResponseVO responseVO = RestTemplateUtil.exchangeHandle("http://localhost:9090/sync/data/unit", HttpMethod.POST, paramMap, ResponseVO.class);
        System.out.println(JSONUtil.toJsonStr(responseVO));

    }

    public static void swap(Student x, int y) {
        Student student = new Student();
        student.setName("kjh");
        x = student;
    }

    private void function(Function<String, Integer> function, String str) {
        Integer apply = function.apply(str);

    }
}
