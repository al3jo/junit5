package com.example.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("JUnit5 @ParametrizedTest with @ValueSource example")
class ParametrizedValueSourceTest {

    @DisplayName("This test passes values to our test defined by @ValueSource")
    @ParameterizedTest(name = "{index} =M message: '{0}'")
    @ValueSource(strings = {"a", "b", "c"})
    void testWithParams(String message) {
        assertNotNull(message);
        System.out.println(String.format("Testing with message '%s'", message));
    }
}