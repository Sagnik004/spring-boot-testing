# Spring Boot Testing

## Testing Terminology

- Test Class
- Test Methods
- Test Scenarios (or) Test Cases
- **Code Under Test** - This is the code (or application) we are testing.
- **Test Fixture** - "A test fixture is a fixed state of a set of objects used as a baseline for running tests. The purpose of a test fixture is to ensure that there is a well known and fixed environment in which tests are run so that results are repeatable." - JUnit Doc
  - Includes: input data, mock objects, loading database with known data, etc.
- **Unit Tests / Unit Testing** - Write code to **test** functional code.
  - Designed to test specific sections of code **independently**.
  - **Should have no external dependencies i.e. no database, no Spring context, no talking to web services, no publishing messages to message brokers etc.**
- **Code Coverage** - Percentage of lines of code tested. Ideal coverage is in the 70-80% range.
- **Integration Tests** - Designed to test behaviors between objects and parts of the overall system.
  - It has much larger scope, and are usually more complex.
  - Can include the Spring Context, database, message brokers etc.
  - Will run much slower than unit tests.
- **Functional Tests** - Typically means we are testing the running (possibly deployed as well) application.
  - Application is live, likely deployed in a known environment.
  - Functional touch points are tested i.e. using a web driver, calling web services, sending / receiving messages, etc.
- **Mocks** - A fake implementation of a class/object used for testing.
  - A test double for dependent objects - like a `datasource`.
  - Can provide expected responses.
  - Can verify expected interactions.
- **Spy** - Like a mock, but real object is used (kind of like a wrapper around the object).
  - Mocks completely replace expected object.
  - Spys are wrappers, but with real object inside it.

## Common Testing Frameworks for Java

- **JUnit** - most popular testing framework for Java, JUnit 6 is the latest version but still JUnit 5 is widely used.
- **TestNG** - alternative to JUnit. Wished to address deficiencies in JUnit. Functionality of TestNG and JUnit have evolved to be very close. Still popular, but much smaller base.
- **Spock** - Testing Framework in Groovy for testing Java (require knowledge of Groovy). Follows BDD approach. Includes own Mocking framework built-in.
- **Cucumber** - BDD Testing Framework. Available for Java, Javascript, and Ruby; very popular in Ruby community, gaining popularity in Java community. Uses **Gherkin** syntax - Natural English like syntax (Describe 'what', not 'how').
- **Mockito** - Mocking framework for testing, only does mocks. Need to use with testing framework such as JUnit or TestNG. Very popular for testing Spring applications.
- **Spring MVC Test** - Testing module found in the Spring Framework. Very versatile for testing Spring MVC Controllers. Provides mock Servlet environment. Used in conjunction with a testing framework such as JUnit, TestNG, or Spock.
- **REST-assured** - Java framework for testing RESTful web services. Provides very powerful DSL for testing Restful interfaces. Can be used with Spring Mock MVC. Tests follow a BDD Syntax.
- **Selenium** - Web Browser Automation. Allows us to write functional tests against web applications. Only Web Browser Automation, need to use a Testing Framework such as JUnit, TestNG, or Spock.
- **GEB** - Groovy Browser Automation. Uses Selenium under the covers. Has JQuery-ish
page element selectors. Needs to be used with a Test Framework, very popular to use along with Spock.
- **Test Containers** - Allows us to launch Docker containers from JUnit Tests. Allows us to start databases, message brokers, etc for integration and functional tests. Can be combined with Selenium for testing web applications.

## Key Points

- Majority of the tests should be *Unit Tests*. *Integration Tests* should be next largest category. *Functional Tests* will come after that, these are much smaller in quantity and least detailed.
- Every possibility of code should be tested.
- Every functional class should be tested independently (mock data as needed to avoid other class method call).
- Mock any outside dependent class. If we create instance, we cannot mock it. It has to be an instance variable (dependency injected).
- In code coverage, try to be 80% during testing.
- We can test every code in local machine.
- Code merge may not be accepted without proper code coverage.
- When we are unit testing we are not actually using Spring Boot Container. We only run the test-class and nothing else.
- There is no mechanism for component scanning, there is no Spring Container, which means there are no beans to inject.

## Packages

- `src/main/java` → functional class code
- `src/test/java` → test class code

## File Name

- `<package_name>.<class_name>` → functional class code
- `<package_name>.<class_name>Test` → test class code (Class name just ends with Test)

## Unit Testing Libraries / Frameworks

- JUnit
- TestNG

`spring-boot-starter-test` package comes bundled with JUnit.

## Mocking Libraries / Frameworks

- Mockito
- PowerMock

`spring-boot-starter-test` package comes with Mockito.

> Junit goes with Mockito; TestNG goes with PowerMock.

## Annotations

- `@Test` → at the top of a method.
- `@ExtendWith(MockitoExtension.class)` → use it at class level in the test class.
- `@InjectMocks` → use it at the top of the functional class declaration inside the test class.
- `@Mock` → use it for other dependent classes used inside the functional class. Declare all those external dependent classes inside the test class, and add @Mock on top of them.

How to write a unit test (the method annotated with `@Test`)?
- **Arrange**: mock the data needed to carry out the unit test
- **Act**: call the method we want to test
- **Assert**: check if the method is behaving correctly.

Why we need `@Mock`, `@InjectMock`, `@ExtendWith` annotations?
- Regular Spring way of object creation is not applicable inside `@Test` method (`@Component`, `@Autowired` etc. will NOT work).
- We cannot use the `new` keyword to create the object of functional class as well, because the functional class might accept multiple other instances in the constructor (parameterized constructor), and we need to then provide instance of all those classes as well, and similarly create instances for those instance dependencies as well. This will be violating unit testing principle of testing independently and mocking behaviour.

> [!WARNING]
> When we use mock objects/instances and call methods of it, the methods does not execute like normal code behaviour, only dummy values are returned. **BUT**, that can be an issue as well if the functional code is expecting it to return some object or values. In that case **we need to override the mock object behaviour**.

For overriding mock object behaviour we need to use `when thenReturn` syntax.

## Assert

Few methods -

- `assertNotNull(object_name)`
- `assertNull(object_name)`
- `assertEquals(value, object/variable)`
