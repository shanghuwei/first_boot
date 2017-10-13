package com.honghu.first_boot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;
    private String cupSize;
    private Integer age;
    private String heightWeight;
    private String hairColor;
    private boolean open;
    private Date createTime;
    @Transient
    private String xueXing;

}
