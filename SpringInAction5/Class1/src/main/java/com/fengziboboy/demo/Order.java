package com.fengziboboy.demo;

import lombok.Data;

import java.util.Date;

/**
 * @program: FirstDemo
 * @description:
 * @author: ZhaoJinbo
 * @create: 2020-05-22 14:55
 **/
@Data
public class Order {
    private Long id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private Date placedDate;
}