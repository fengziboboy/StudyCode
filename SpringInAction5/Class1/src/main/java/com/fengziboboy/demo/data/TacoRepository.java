package com.fengziboboy.demo.data;

import com.fengziboboy.demo.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    Taco save(Taco taco);
}
