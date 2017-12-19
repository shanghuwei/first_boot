package com.honghu.first_boot.oneAndmany;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order,Integer> {
}
