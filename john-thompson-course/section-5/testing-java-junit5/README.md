# Introduction to JUnit 5 with Maven

This source code repository contains JUnit 5 test examples with Maven.

## Setup

### Requirements

* Should use Java 11 or higher. Previous versions of Java are un-tested.
* Use Maven 3.5.2 or higher

### Project Details

Just a dummy Spring web app type project, but without any of the Spring features. The application is not expected to run, it just provides us a base to write different types of JUnit test cases aligning to real world applications.

## JUnit Assertion Lambda's

- JUnit 5 incorporates support of lambda's in assertions
- **Grouped Assertions** - all assertions run in block, all failures reported
- **Dependent Assertions** - allows for blocks of grouped assertions
- Expected exceptions are tested with `assertThrows` lambda expression
- Timeouts are tested with `assertTimeout` lambda expression

## Assertion Frameworks

- JUnit 5 works with popular assertion frameworks, both generalized and specialized like JSON assertions.
- Popular options:
  - AssertJ
  - Hamcrest
  - Truth

[JUnit 5 documentation for Assertion framework](https://docs.junit.org/5.14.0/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html)

### JUnit 5 Grouped Assertions

Using `assertAll` method it allows multiple assertions to execute together ensuring all are evaluated even if one fails.

**Examples:**

```java
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
void groupedAssertionWithMsg() {
  // Given
  Person person = new Person(1L, "Joe", "Buck");

  // Then
  assertAll("Test props set",
          () -> assertEquals("Joe2", person.getFirstName(), "First name failed"),
          () -> assertEquals("Buck2", person.getLastName(), "Last name failed"));
}
```

### JUnit 5 Dependent Assertions

When we have nested complex objects then we can use this feature. Example: `Owner` class inheriting from `Person` class.

**Example:**

```java
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
```

### Skipping JUnit Tests

- We can skip JUnit tests using the `@Disabled` keyword.
- It can be used above method(s) to skip testing those method(s).
- It can also be used above class(es) to skip testing those class(es).
- `@Disabled` can optionally take a `value` property as well. Example: `@Disabled(value = "Disabled until we learn Mocking!")`

