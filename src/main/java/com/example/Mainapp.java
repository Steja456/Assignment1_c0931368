package com.example;

public class Mainapp {
    public static void main(String[] args) {
        // Create a person without a dog
        Person alice = new Person("Alice", 30);

        // Try to change the dog's name (should throw an exception)
        try {
            alice.changeDogsName("Buddy");
        } catch (RuntimeException e) {
            System.out.println("Unable to change dog's name: " + e.getMessage());
        }
    }
}
