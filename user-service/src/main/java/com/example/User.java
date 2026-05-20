package com.example;  

import jakarta.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.validation.constraints.*;

@Entity
public class User extends PanacheEntity {

    @NotBlank
    public String name;

    @Min(18)
    public int age;
}
