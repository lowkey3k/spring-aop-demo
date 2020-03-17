package com.demo.other;

import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * @author YangChao
 * @create 2018-04-09 8:38
 **/
@Slf4j
public class RestTemplateUtil {

    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static RestTemplate INSTANCE = new RestTemplateBuilder().additionalMessageConverters(new StringHttpMessageConverter(Charset.forName("UTF-8"))).build();
    }

    /**
     * 获取单例
     */
    public static RestTemplate getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 创建HttpEntity
     *
     * @param body
     * @param <T>
     * @return
     */
    public static <T> HttpEntity createHttpEntity(T body) {
        return createHttpEntity(body, null);
    }

    public static <T> HttpEntity createHttpEntity(T body, HttpHeaders addon) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        if (MapUtil.isNotEmpty(addon)) {
            headers.putAll(addon);
        }
        if (null != body) {
            if (body instanceof String) {
                return new HttpEntity<>(body, headers);
            } else {
                return new HttpEntity<>(JSONUtil.toJsonStr(body), headers);
            }
        } else {
            return new HttpEntity<>(headers);
        }
    }

    /**
     * http请求
     *
     * @param url
     * @param method
     * @param body
     * @param responseType
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> S exchangeHandle(String url, HttpMethod method, T body, Class<S> responseType) {
        log.info("RestTemplateUtil.exchangeHandle request ====== anthServiceUrl : {}, body : {}", url, body);
        String response = RestTemplateUtil.getInstance().exchange(url, method, RestTemplateUtil.createHttpEntity(body), String.class).getBody();
        log.info("RestTemplateUtil.exchangeHandle response ====== response : {}", response);
        return JSONUtil.toBean(response, responseType);
    }

    public static <S, T> S exchangeHandle(String url, HttpMethod method, T body, HttpHeaders headers, Class<S> responseType) {
        log.info("RestTemplateUtil.exchangeHandle request ====== anthServiceUrl : {}, body : {}", url, body);
        String response = RestTemplateUtil.getInstance().exchange(url, method, RestTemplateUtil.createHttpEntity(body, headers), String.class).getBody();
        log.info("RestTemplateUtil.exchangeHandle response ====== response : {}", response);
        return JSONUtil.toBean(response, responseType);
    }


    /**
     * http代理请求
     *
     * @param url
     * @param actualUrl
     * @param method
     * @param body
     * @param responseType
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> S exchangeHandleProxy(String url, String actualUrl, HttpMethod method, T body, Class<S> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("dest", actualUrl);
        HttpEntity httpEntity;
        if (null != body) {
            httpEntity = new HttpEntity<>(JSONUtil.toJsonStr(body), headers);
        } else {
            httpEntity = new HttpEntity<>(headers);
        }
        log.info("RestTemplateUtil.exchangeHandleProxy request ====== anthServiceUrl : {}, body : {}", url, body);
        String response = RestTemplateUtil.getInstance().exchange(url, method, httpEntity, String.class).getBody();
        log.info("RestTemplateUtil.exchangeHandleProxy response ====== response : {}", response);
        return JSONUtil.toBean(response, responseType);
    }

}