package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DogTest {

    @Test
    public void testDogCreation() {
        Dog dog = new Dog("Jimmy", 4);
        assertEquals("Jimmy", dog.getName());
        assertEquals(4, dog.getAge());
    }

    @Test
    public void testSetName() {
        Dog dog = new Dog("Jimmy", 4);
        dog.setName("Krish");
        assertEquals("Krish", dog.getName());
    }

    @Test
    public void testSetAge() {
        Dog dog = new Dog("Jimmy", 4);
        dog.setAge(6);
        assertEquals(6, dog.getAge());
    }
}
