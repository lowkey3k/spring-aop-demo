package com.demo.repository;

import com.demo.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LiHaitao
 * @description ShopRepository:
 * @date 2019/12/13 10:38
 **/
public interface ShopRepository extends JpaRepository<Shop, Long> {

}
