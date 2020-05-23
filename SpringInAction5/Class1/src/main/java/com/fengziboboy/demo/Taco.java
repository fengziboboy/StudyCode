package com.fengziboboy.demo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Taco {
    private Long id;
    private String name;
    private List<Ingredient> ingredients;
    private Date createDate;
}
