package com.example.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUnit5 @ParametrizedTest with custom argument type example")
class ParametrizedCustomArgumentTypeExampleTest {

    @DisplayName("Should receive properties of custom formats")
    @ParameterizedTest
    @CsvSource({
            "server.port=8080",
            "username=admin"
    })
    void passProperties(@ConvertWith(PropertyConverter.class) Property p) {
        assertEquals(p.toString(), String.format("%s=%s", p.getName(), p.getValue()));
        System.out.println(String.format("Testing Property %s", p));
    }

    static final class Property {
        private final String name;
        private final String value;

        Property(String name, String value) {
            this.name = name;
            this.value = value;
        }

        String getName() {return name;}
        String getValue() {return value;}
        @Override public String toString() {return String.format("%s=%s", name, value);}
    }

    static final class PropertyConverter implements ArgumentConverter {
        @Override
        public Object convert(Object o, ParameterContext parameterContext) throws ArgumentConversionException {
            String[] source = checkAndConvertSource(o).split("=");
            return new Property(source[0], source[1]);
        }

        private String checkAndConvertSource(Object o) {
            if (null == o) {
                throw new IllegalArgumentException("Source cannot be null");
            }
            if (!o.getClass().equals(String.class)) {
                throw new IllegalArgumentException("Source must be a String");
            }
            String s = (String) o;
            if (equals(s.trim().isEmpty())) {
                throw new IllegalArgumentException("Source cannot be empty");
            }
            return s.trim();
        }
    }



}