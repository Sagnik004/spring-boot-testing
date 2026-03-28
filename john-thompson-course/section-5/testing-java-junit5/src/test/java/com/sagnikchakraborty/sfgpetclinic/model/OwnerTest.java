package com.sagnikchakraborty.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Jane", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("9875645878");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Jane", owner.getFirstName(), "First name did not match"),
                        () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity()),
                        () -> assertEquals("9875645878", owner.getTelephone(), "Telephone did not match"))
        );
    }
}