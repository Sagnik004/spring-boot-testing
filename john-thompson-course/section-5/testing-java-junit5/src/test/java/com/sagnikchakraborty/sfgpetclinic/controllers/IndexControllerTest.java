package com.sagnikchakraborty.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test proper view name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view returned");
        assertEquals("index", controller.index(), () -> "Another expensive message. " +
                "Make me only if you have to!");
    }

    @Test
    @DisplayName("Test Exception")
    void oopsHandler() {
        // Performance tip: If we have an expensive operation to generate the error message,
        // then we can put that in a lambda expression. It gets called and evaluated only
        // if assertion fails.
        /*
        assertTrue("notimplemented".equals(controller.oopsHandler()), () -> "This is some expensive " +
                "message to build " +
                "for my test");
        */

        assertThrows(ValueNotFoundException.class, () -> controller.oopsHandler());
    }

    @Disabled
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }

    @Disabled
    @Test
    void testTimeoutPreempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I wont make it");
        });
    }
}