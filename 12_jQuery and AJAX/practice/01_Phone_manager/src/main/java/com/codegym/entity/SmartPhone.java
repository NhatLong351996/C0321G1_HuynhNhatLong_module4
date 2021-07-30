package com.codegym.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "smartphones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmartPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String producer;
    private String model;
    private double price;

    @Override
    public String toString() {
        return producer+": "+model+" with price "+price;
    }
}
