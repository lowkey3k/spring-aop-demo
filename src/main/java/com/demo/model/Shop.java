package com.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author LiHaitao
 * @description Shop:
 * @date 2019/12/13 10:37
 **/
@Entity
@Table(name = "T_SHOP")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shop extends BaseEntity {

    private String shopName;

    private Long shopTotal;

}
