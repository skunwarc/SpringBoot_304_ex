package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long year;

    @NotNull
    @Size(min=4)
    private String make;

    @NotNull
    @Size(min=4)
    private String model;

    public long getYear() {
        return year;
    }

    public void setFields(long fields) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Car(@NotNull @Size(min = 4) String make, @NotNull @Size(min = 4) String model) {
        this.make = make;
        this.model = model;
    }

    public Car() {
    }
}
