package com.honghu.first_boot.Inheritance;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
//@DiscriminatorValue("teacher")
public class Teacher extends Person {
    private String title;
}
