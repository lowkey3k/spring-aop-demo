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

    @PostMapping("/ga/xinghuo-apaas-zgrsuser/deptInfo/v1/getDeptBasicInfoNodeAll")
    public JSONObject department(DepartmentRequest request) {
        log.info("request param>>>>{}", request);
        String str = "{\n" +
                "\"success\": true,\n" +
                "\"msg\": \"\\u67e5\\u8be2\\u6210\\u529f\",\n" +
                "\"obj\": [\n" +
                "\n" +
                "{\n" +
                "\"id\": \"38096166801375\",\n" +
                "\"deptCode\": \"565465465\",\n" +
                "\"parentId\": \"3772280315523\",\n" +
                "\"name\": \"\\u6d4b\\u8bd5 0815-2--\\u6d4b\\u8bd5\\u4fee\\u6539 04\",\n" +
                "\"py\": \"cs0815-2--csxg04\",\n" +
                "\"category\": 1,\n" +
                "\"levelId\": 1,\n" +
                "\"remark\": \"\",\n" +
                "\"status\": 1,\n" +
                "\"isDeleted\": 0,\n" +
                "\"description\": \"\\u90e8\\u95e8\\u65b0\\u589e\\u6d4b\\u8bd5------\\u6d4b\\u8bd5\\u4fee\\u6539\",\n" +
                "\"path\": \"/14971319099588/3561540726397/38096166801375/\",\n" +
                "\"pathLevel\": 3,\n" +
                "\"pathtree\": \"/\\u6240\\u6709\\u90e8\\u95e8/\\u6d4b\\u8bd5 1/\\u6d4b\\u8bd5 0815-2/\",\n" +
                "\"listOrder\": 4,\n" +
                "\"phone\": \"136001968\",\n" +
                "\"deptNameTwo\": \"\",\n" +
                "\"isLeaf\": 1,\n" +
                "\"uuid\": \"5988cd70-ffea-47ad-95e6-4c984373b\",\n" +
                "\"qbType\": 0,\n" +
                "\"parentDeptCode\": \"1544545\",\n" +
                "\"oldDeptCode\": \"\",\n" +
                "\"organizeDes\": \"\",\n" +
                "\"parentDeptName\": \"\",\n" +
                "\"deptOtherName\": \"\",\n" +
                "\"deptAbbreviation\": \"\",\n" +
                "\"zgrsDelete\": 0\n" +
                "},\n" +
                "{\n" +
                "\"id\": \"3772280315523\",\n" +
                "\"deptCode\": \"1321\",\n" +
                "\"parentId\": \"22\",\n" +
                "\"name\": \"\\u6d4b\\u8bd5 22255\",\n" +
                "\"py\": \"cs22255\",\n" +
                "\"category\": 1,\n" +
                "\"levelId\": 1,\n" +
                "\"remark\": \"\",\n" +
                "\"status\": 1,\n" +
                "\"isDeleted\": 0,\n" +
                "\"description\": \"\",\n" +
                "\"path\": \"/14971319099588/3561540726397/\",\n" +
                "\"pathLevel\": 3,\n" +
                "\"pathtree\": \"/\\u6240\\u6709\\u90e8\\u95e8/\\u6d4b\\u8bd5 1/37722803155238/\",\n" +
                "\"listOrder\": 3,\n" +
                "\"phone\": \"\",\n" +
                "\"deptNameTwo\": \"\",\n" +
                "\"isLeaf\": 1,\n" +
                "\"uuid\": \"b81775dd-ccbc-4e8d-a370-0865cd5\",\n" +
                "\"qbType\": 1,\n" +
                "\"parentDeptCode\": \"15445454\",\n" +
                "\"oldDeptCode\": \"\",\n" +
                "\"organizeDes\": \"\",\n" +
                "\"parentDeptName\": \"\",\n" +
                "\"deptOtherName\": \"\",\n" +
                "\"deptAbbreviation\": \"\",\n" +
                "\"zgrsDelete\": 0\n" +
                "}\n" +
                "],\n" +
                "\"flag\": 1,\n" +
                "\"code\": 200,\n" +
                "\"errorCode\": 200,\n" +
                "\"cmd\": \"/deptInfo/v1/getDeptBasicInfoNodeAll\",\n" +
                "\"count\": 0\n" +
                "}";
        return JSONUtil.parseObj(str);

    }

    @PostMapping("/ga/xinghuo-apaas-zgrsuser/userInfo/v1/getUserBasicInfoAll")
    public JSONObject user(@RequestBody UserRequest request) {
        log.info("request param>>>>{}", request);
        int total = 2;
        Integer pageNo = request.getPageNo();
        Integer pageSize = request.getPageSize();
        if ((pageNo - 1) * pageSize <= total) {
            String str = "{\n" +
                    "\"success\": true,\n" +
                    "\"msg\": \"\\u67e5\\u8be2\\u6210\\u529f\",\n" +
                    "\"obj\": [\n" +
                    "{\n" +
                    "\"id\": \"2473579994152\",\n" +
                    "\"userCode\": \"05433\",\n" +
                    "\"userName\": \"刘浩\",\n" +
                    "\"userLoginId\": \"054\",\n" +
                    "\"idcard\": \"610324199404193112\",\n" +
                    "\"departmentId\": \"3772280315523\",\n" +
                    "\"status\": 1,\n" +
                    "\"userType\": \"\\u6c11\\u8b66\\u8d26\\u53f7\",\n" +
                    "\"isDeleted\": 0,\n" +
                    "\"listOrder\": 2,\n" +
                    "\"gender\": 1,\n" +
                    "\"birthday\": 1533698885000,\n" +
                    "\"age\": 20,\n" +
                    "\"position\": \"\\u652f\\u961f\\u957f\",\n" +
                    "\"mobilePhone2\": \"18938086834\",\n" +
                    "\"imei\": \"\",\n" +
                    "\"equipmentNum\": \"\",\n" +
                    "\"leadercode\": \"44030000\",\n" +
                    "\"job\": \" \\u79d1 \\u6280 \\u7ba1 \\u7406 \",\n" +
                    "\"policeRank\": \"\\u4e09\\u7ea7\\u8b66\\u76d1\",\n" +
                    "\"userStatus\": \"\\u5728\\u804c\\u9886\\u5bfc\",\n" +
                    "\"rank\": \"\\u6b63\\u5904\\u7ea7\",\n" +
                    "\"deptCode\": \"1321\",\n" +
                    "\"userId\": \"a986de15-02b7-43fc-b13b-544b881cf\",\n" +
                    "\"identity\": \"\",\n" +
                    "\"deptName\": \"\\u8b66\\u5bdf\\u652f\\u961f\",\n" +
                    "\"curstatus\": \"\"\n" +
                    "},\n" +
                    "{\n" +
                    "\"id\": \"247358043874918\",\n" +
                    "\"userCode\": \"123342ss\",\n" +
                    "\"userName\": \"刘宇鹏\",\n" +
                    "\"userLoginId\": \"0545\",\n" +
                    "\"idcard\": \"610324199404193112\",\n" +
                    "\"departmentId\": \"38096166801375\",\n" +
                    "\"status\": 1,\n" +
                    "\"userType\": \"\\u6c11\\u8b66\\u8d26\\u53f7\",\n" +
                    "\"isDeleted\": 0,\n" +
                    "\"listOrder\": 4,\n" +
                    "\"gender\": 1,\n" +
                    "\"birthday\": 1533178389000,\n" +
                    "\"age\": 20,\n" +
                    "\"position\": \" \\u526f \\u652f \\u961f \\u957f \",\n" +
                    "\"mobilePhone2\": \"13392899345\",\n" +
                    "\"imei\": \"\",\n" +
                    "\"equipmentNum\": \"\",\n" +
                    "\"leadercode\": \"440300000\",\n" +
                    "\"job\": \" \\u79d1 \\u6280 \\u7ba1 \\u7406 \",\n" +
                    "\"policeRank\": \"\\u4e00\\u7ea7\\u8b66\\u7763\",\n" +
                    "\"userStatus\": \"\\u5728\\u804c\\u9886\\u5bfc\",\n" +
                    "\"rank\": \"\\u526f\\u5904\\u7ea7\",\n" +
                    "\"deptCode\": \"565465465\",\n" +
                    "\"userId\": \"0404d8bb-e995-4b1c-95fb-966f0223\",\n" +
                    "\"identity\": \"\",\n" +
                    "\"deptName\": \"\\u8b66\\u5bdf\\u652f\\u961f\",\n" +
                    "\"curstatus\": \"\"\n" +
                    "}\n" +
                    "],\n" +
                    "\"flag\": 1,\n" +
                    "\"code\": 200,\n" +
                    "\"errorCode\": 200,\n" +
                    "\"cmd\": \"/userInfo/v1/getUserBasicInfoAll\",\n" +
                    "\"count\": 104\n" +
                    "}";

            return JSONUtil.parseObj(str);
        }
        return null;
    }
}
