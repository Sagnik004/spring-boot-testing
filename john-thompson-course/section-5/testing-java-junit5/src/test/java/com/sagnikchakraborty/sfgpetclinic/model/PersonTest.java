package com.sagnikchakraborty.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertions() {
        // Given
        Person person = new Person(1L, "Joe", "Buck");

        // Then
        assertAll("Test props set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Buck", person.getLastName()));
    }

    @Test
    void groupedAssertionMsgs() {
        // Given
        Person person = new Person(1L, "Joe", "Buck");

        // Then
        assertAll("Test props set",
                () -> assertEquals("Joe2", person.getFirstName(), "First name failed"),
                () -> assertEquals("Buck2", person.getLastName(), "Last name failed"));
    }
}