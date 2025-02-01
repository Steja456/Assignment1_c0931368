package com.example;

import java.util.Optional;

public class Person {
    private String name;
    private Integer age;
    private Optional<Dog> dog; // Using Optional to handle cases where a person may not own a dog

    // Constructor for a person WITHOUT a dog
    public Person(String name, Integer age) {
        this(name, age, null);
    }

    // Constructor for a person WITH a dog
    public Person(String name, Integer age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = Optional.ofNullable(dog);
    }

    // Getters
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Optional<Dog> getDog() {
        return dog;
    }

    // Check if the person has an old dog (age 10 or older)
    public boolean hasOldDog() {
        return dog.map(d -> d.getAge() >= 10).orElse(false);
    }

    // Change dog's name if the person owns a dog, otherwise throw an exception
    public void changeDogsName(String newName) {
        dog.ifPresentOrElse(
            d -> d.setName(newName),
            () -> { throw new RuntimeException(name + " does not own a dog!"); }
        );
    }
}
