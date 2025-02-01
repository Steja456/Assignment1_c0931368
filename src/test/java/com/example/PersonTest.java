package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testPersonCreationWithoutDog() {
        Person person = new Person("Aaron", 25);
        assertEquals("Aaron", person.getName());
        assertEquals(25, person.getAge());
        assertFalse(person.getDog().isPresent());
    }

    @Test
    public void testPersonCreationWithDog() {
        Dog dog = new Dog("Jimmy", 5);
        Person person = new Person("Can", 50, dog);
        assertTrue(person.getDog().isPresent());
        assertEquals(dog, person.getDog().get());
    }

    @Test
    public void testHasOldDogTrue() {
        Dog oldDog = new Dog("Pax", 6);
        Person person = new Person("Krish", 45, oldDog);
        assertTrue(person.hasOldDog());
    }

    @Test
    public void testHasOldDogFalse() {
        Dog youngDog = new Dog("Pax", 6);
        Person person = new Person("Krish", 45, youngDog);
        assertFalse(person.hasOldDog());
    }

    @Test
    public void testChangeDogsNameSuccessfully() {
        Dog dog = new Dog("Hex", 5);
        Person person = new Person("Fina", 23, dog);
        person.changeDogsName("Pina");
        assertEquals("Pina", person.getDog().get().getName());
    }

    @Test
    public void testChangeDogsNameThrowsException() {
        Person person = new Person("Harsha", 39);
        Exception exception = assertThrows(RuntimeException.class, () -> person.changeDogsName("Prem"));
        assertEquals("Harsha does not own a dog!", exception.getMessage());
    }
}
