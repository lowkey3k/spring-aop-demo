package com.demo.redis;

import cn.hutool.core.collection.CollectionUtil;
import com.demo.model.Shop;
import com.demo.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LiHaitao
 * @description RedissonTestController:
 * @date 2019/12/13 10:16
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class RedissonTestController {
    //
    //    @Autowired
    //    private RLock lock;


    @Autowired
    private ShopRepository shopRepository;


    @GetMapping("/plus")
    public String plus(@RequestParam Integer sum) throws InterruptedException {
        //        lock.lock();
        //查看库存，确认库存是否充足保证下单可以成功
        Thread.sleep(5000);
        List<Shop> all = shopRepository.findAll();
        if (CollectionUtil.isNotEmpty(all)) {
            log.info("*******库存足够********>>>{}", all.size());
            try {
                shopRepository.delete(all.get(0));//删除一件商品
                log.info("********库存足够，可以下单>>>{}", all.size());
            } catch (Exception e) {
                log.info("******库存查找失败{}", shopRepository.findAll().size());
            }
        } else {
            log.info("库存不够>>>>>>>>>>>{}", all.size());
        }
        //        lock.unlock();
        return "success";
    }

    @GetMapping("/release")
    public Integer release() {
        //        lock.lock();
        return 1;
    }

}
