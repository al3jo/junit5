package com.example.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUnit5 @ParametrizedTest with @CsvSource and @CsvFileSource example")
class ParametrizedCsvSourceExampleTest {

    @DisplayName("Should calculate the correct sum, from a CVS source")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource({
            "3, 2, 5",
            "2, 7, 9"
    })
    void sum(int a, int b, int sum) {
        assertEquals(sum, a + b);
        System.out.println(String.format("Testing %d + %d = %d", a, b, sum));
    }

    @DisplayName("Should calculate the correct sum from a File CVS source")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvFileSource(numLinesToSkip = 1, resources = "/numbers.csv")
    void sumFromFile(int a, int b, int sum) {
        assertEquals(sum, a + b);
        System.out.println(String.format("Testing %d + %d = %d (from file)", a, b, sum));
    }

}