package com.example.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

@DisplayName("JUnit5 @ParametrizedTest with @EnumSource values example")
class ParametrizedEnumSourceExampleTest {

    @DisplayName("Parametrized test with enum values")
    @ParameterizedTest
    @EnumSource(Type.class)
    void testWithEnum(Type t) {
        System.out.println(String.format("Testing with enum value '%s'", t));
    }

    @DisplayName("Parametrized test with some enum values")
    @ParameterizedTest
    @EnumSource(value = Type.class, names = {"TYPE_C", "TYPE_A"})
    void testWithSomeEnums(Type t) {
        System.out.println(String.format("Testing with enum value '%s'", t));
    }

    enum Type {TYPE_A, TYPE_B, TYPE_C}
}
