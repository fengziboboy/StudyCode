package com.fengziboboy.demo.data;

import com.fengziboboy.demo.Ingredient;
import com.fengziboboy.demo.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByDeliveryZip(String deliveryZip);

    List<Order> readOrdersByDeliveryZipAndPlacedDateBetween(String deliveryZip, Date startDate, Date endDate);

    List<Order> findByDeliveryToAndCityAllIgnoresCase(String deliveryTo, String deliveryCity);

    List<Order> findByDeliveryCityOrderByDeliveryTo(String city);

    @Query("Order o where o.deliveryCity='Seattle'")
    List<Order> readOrdersDeliveredInSeattle();

}
