package com.example.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUnit5 @ParametrizedTest with @MethodSource example")
class ParametrizedMethodSourceExampleTest {

    @DisplayName("Should calculate the correct sum from an implicit method source")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @MethodSource
    void sumFromStaticFactory(int a, int b, int sum) {
        assertEquals(sum, a + b);
        System.out.println(String.format("Testing %d + %d = %d (from implicit factory)", a, b, sum));
    }

    @DisplayName("Should calculate the correct sum from an explicit method source")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @MethodSource("sumFromStaticFactory")
    void sumFromExplicitStaticFactory(int a, int b, int sum) {
        assertEquals(sum, a + b);
        System.out.println(String.format("Testing %d + %d = %d (from explicit factory)", a, b, sum));
    }

    // This is the method that sources the parameters for the test.
    // Each line must contain all params in the same order they are declared
    // If the name of the factory is the same as the test method, no need to specify the factory in the annotation
    private static Stream<Arguments> sumFromStaticFactory() {
        return Stream.of(
                Arguments.of(5, 2, 7),
                Arguments.of(2, 3, 5)
        );
    }

}