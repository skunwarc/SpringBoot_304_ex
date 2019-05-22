package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements CommandLineRunner {

    @Autowired
    CarRepository repository;

    @Override
    public void run(String... strings) throws  Exception{

        Car car = new Car("Toyota","Camry");
        repository.save(car);

        car = new Car("Nissan","Altima");
        repository.save(car);

        car = new Car("Honda","Accord");
        repository.save(car);

    }

}
