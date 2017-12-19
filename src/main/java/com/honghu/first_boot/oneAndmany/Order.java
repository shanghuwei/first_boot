package com.honghu.first_boot.oneAndmany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    @Id
    private Integer id;
    private Double amount;
//    @OneToMany( orphanRemoval = true,cascade = {CascadeType.ALL})
//    @JoinColumn(name = "orderId")
//    private List<OrderItem> itemList;
}
