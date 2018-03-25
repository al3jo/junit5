package com.example.junit5;

import org.junit.jupiter.api.*;

@DisplayName("Example JUnit 5 Nested Test Classes")
class NestedExampleTest {

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

    @Nested
    @DisplayName("Tests for the method A")
    class A {
        @BeforeEach
        void beforeEach() {
            System.out.println("This executes before each test on Class A");
        }

        @AfterEach
        void afterEach() {
            System.out.println("This executes after each test on Class A");
        }

        @Test
        @DisplayName("Example Test for method A")
        void testMethodA() {
            System.out.println("Test for method A");
        }

        @Nested
        @DisplayName("When X is True tests")
        class WhenX {
            @BeforeEach
            void beforeEach() {
                System.out.println("This executes before each test on When X");
            }

            @AfterEach
            void afterEach() {
                System.out.println("This executes after each test on When X");
            }

            @Test
            @DisplayName("Example Test for method A When X")
            void testMethodAWhenX() {
                System.out.println("Test for method A When X");
            }
        }
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
