package com.example.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUnit5 @ParametrizedTest with @ArgumentSource example")
class ParametrizedArgumentsSourceExampleTest {

    @DisplayName("Should calculate the correct sum from a custom argument source")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @ArgumentsSource(CustomArgumentProvider.class)
    void sumFromCustomArgsProvider(int a, int b, int sum) {
        assertEquals(sum, a + b);
        System.out.println(String.format("Testing %d + %d = %d (from custom arg provider)", a, b, sum));
    }

    static class CustomArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(5, 2, 7),
                    Arguments.of(2, 3, 5)
            );
        }
    }

}