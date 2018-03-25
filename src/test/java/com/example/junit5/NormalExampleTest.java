package com.example.junit5;

import org.junit.jupiter.api.*;

@DisplayName("Example JUnit 5 Test Class")
class NormalExampleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("This executes before all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("This executes before each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("This executes after all tests");
    }

    @AfterEach
    void afterEach() {
        System.out.println("This executes after each test");
    }


    @Test
    @DisplayName("Test A: some test")
    void testA()
    {
        System.out.println("Test A");
    }

    @Test
    @DisplayName("Test B: some other test")
    void testB()
    {
        System.out.println("Test B");
    }

}
