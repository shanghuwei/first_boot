package com.honghu.first_boot.Inheritance;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
//@DiscriminatorValue("student")
public class Student extends Person{
    private Integer score;
}
