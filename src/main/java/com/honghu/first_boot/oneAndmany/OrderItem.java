package com.honghu.first_boot.oneAndmany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private Double price;
    private Integer qty;
//    private Integer orderId;
}
