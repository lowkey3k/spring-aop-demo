package com.demo.other;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiHaitao
 * @description CompanyTestController:
 * @date 2019/12/18 9:52
 **/
@RestController
@RequestMapping
@Slf4j
public class CompanyTestController {

    @PostMapping(value = "/sync/data/unit")
    public JSONObject department(@RequestBody JSONObject jsonObject) {
        log.info("request param>>>>{}", jsonObject);
        String str = "{\n" +
                "\t\"dataList\":[{\n" +
                "\t\t\t\"id\":\"110011123\",\n" +
                "\t\"pid\":\"105a53dbee5944c7a3593005a0c95eb5\",\n" +
                "\t\n" +
                "\t\"name\":\"haiyun测试\"\n" +
                "\t}]\n" +
                "\n" +
                "}";
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode("200");
        responseVO.setMessage("ok");
        return JSONUtil.parseObj(responseVO);

    }

    @PostMapping("/sync/data/userList")
    public JSONObject userByDept(@RequestBody UserRequestDTO request) {
        log.info("request param>>>>{}", JSONUtil.toJsonStr(request));
        String json = "{\n" +
                "    \"code\": 0,\n" +
                "    \"msg\": \"success\",\n" +
                "    \"data\":{ userList:  [\n" +
                "        {\n" +
                "            \"cardnum\": \"610324199409263124\",\n" +
                "            \"userNa\": \"张三1\",\n" +
                "            \"num\": \"0003212\",\n" +
                "            \"mobile\": \"152000000000\",\n" +
                "            \"company\": \"1101101\",\n" +
                "            \"unitInfo\": [\n" +
                "                {\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"children\": [],\n" +
                "                            \"name\": \"高速交警总队\",\n" +
                "                            \"pid\": \"420000000000\",\n" +
                "                            \"id\": \"420001000000\",\n" +
                "                            \"position\": \"50\",\n" +
                "                            \"type\": \"1\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"name\": \"湖北省公安厅\",\n" +
                "                    \"pid\": \"000000000000\",\n" +
                "                    \"id\": \"420000000000\",\n" +
                "                    \"position\": \"\",\n" +
                "                    \"type\": \"1\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"userId\": 1,\n" +
                "            \"xgsj\": \"209102010802\"\n" +
                "        }\n" +
                "    ]}\n" +
                "}\n";

        return JSONUtil.parseObj(json);
    }


    @PostMapping("/sync/data/user")
    public JSONObject user(@RequestBody UserRequestDTO request) {
        log.info("request param>>>>{}", JSONUtil.toJsonStr(request));
        String json = "{\n" +
                "    \"code\": 0,\n" +
                "    \"msg\": \"success\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"cardnum\": \"420105199803262342\",\n" +
                "            \"userNa\": \"张三1\",\n" +
                "            \"num\": \"00032123\",\n" +
                "            \"mobile\": \"152000000000\",\n" +
                "            \"company\": \"1101101\",\n" +
                "            \"unitInfo\": [\n" +
                "                {\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"children\": [],\n" +
                "                            \"name\": \"高速交警总队\",\n" +
                "                            \"pid\": \"420000000000\",\n" +
                "                            \"id\": \"420001000000\",\n" +
                "                            \"position\": \"50\",\n" +
                "                            \"type\": \"1\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"name\": \"湖北省公安厅\",\n" +
                "                    \"pid\": \"000000000000\",\n" +
                "                    \"id\": \"420000000000\",\n" +
                "                    \"position\": \"\",\n" +
                "                    \"type\": \"1\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"userId\": 1,\n" +
                "            \"xgsj\": \"209102010802\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";

        return JSONUtil.parseObj(json);
    }
}
