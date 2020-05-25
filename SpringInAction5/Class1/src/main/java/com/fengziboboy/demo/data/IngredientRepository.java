package com.fengziboboy.demo.data;

import com.fengziboboy.demo.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @program: FirstDemo
 * @description:
 * @author: ZhaoJinbo
 * @create: 2020-05-22 20:51
 **/
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    List<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);
}
