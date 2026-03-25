package com.sagnikchakraborty;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

    private Greeting greeting;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before Class/Before All - I am only called Once at the start!!!");
    }

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

    @AfterEach
    void tearDown() {
        System.out.println("In after each...");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After Class/After All - I am only called Once at the end!!!");
    }
}