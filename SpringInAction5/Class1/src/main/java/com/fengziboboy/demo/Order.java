package com.fengziboboy.demo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: FirstDemo
 * @description:
 * @author: ZhaoJinbo
 * @create: 2020-05-22 14:55
 **/
@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {
    private static final long serialVersionUID = -7680387757541868002L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String deliveryTo;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private Date placedDate;
    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco taco) {
        this.tacos.add(taco);
    }

    @PrePersist
    void placedDate() {
        this.placedDate = new Date();
    }
}
