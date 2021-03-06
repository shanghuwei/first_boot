package com.honghu.first_boot.oneAndmany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "orders")
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private Double amount;
    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL)
//    @JoinColumn(name = "orderId")
    @JoinTable(name = "orders_orderItem")
    private List<OrderItem> orderItems;
}


