package com.sagnikchakraborty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

    private Greeting greeting;

    @BeforeEach
    void setUp() {
        System.out.println("In before each...");
        greeting = new Greeting();
    }

    @Test
    void helloWorld() {
        String result = greeting.helloWorld();
        System.out.println(result);
    }

    @Test
    void testHelloWorld() {
        String result = greeting.helloWorld("Sagnik");
        System.out.println(result);
    }
}