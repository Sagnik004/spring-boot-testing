package com.sagnikchakraborty;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

    @Test
    void helloWorld() {
        Greeting greeting = new Greeting();
        String result = greeting.helloWorld();
        assertEquals("Hello World", result);
    }

    @Test
    void testHelloWorld() {
        Greeting greeting = new Greeting();
        String result = greeting.helloWorld("Sagnik");
    }
}