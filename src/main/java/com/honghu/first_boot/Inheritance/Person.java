package com.honghu.first_boot.Inheritance;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "discriminator" ,discriminatorType = DiscriminatorType.STRING)//string
//@DiscriminatorValue("person")
@NoArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String name;
}
