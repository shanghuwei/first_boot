package com.honghu.first_boot.oneAndmany;

import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepo extends CrudRepository<OrderItem,Integer> {
}
