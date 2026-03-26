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


