package com.fengziboboy.demo.data;

import com.fengziboboy.demo.Ingredient;
import com.fengziboboy.demo.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order save(Order order);

    List<Order> findByZip(String zip);

    List<Order> readOrdersByZipAndPlacedDateBetween(String zip, Date startDate, Date endDate);

    List<Order> findByZipToAndCityAllIgnoresCase(String zip, Date startDate, Date endDate);

    List<Order> readOrdersByZipAndPlacedDateBetween(String zip, Date startDate, Date endDate);

}
