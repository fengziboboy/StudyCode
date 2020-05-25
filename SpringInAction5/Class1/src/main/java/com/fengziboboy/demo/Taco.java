package com.fengziboboy.demo;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size()
    private String name;
    @ManyToMany(targetEntity = Ingredient.class)
    @Size()
    private List<Ingredient> ingredients;
    private Date createDate;

    @PrePersist
    void createDate() {
        this.createDate = new Date();
    }
}
