package com.ecpe205;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {
    Calculator calc;

    @BeforeAll
    void setup(){
        calc = new Calculator();
    }

    //CREATE A TEST TO TEST isEven
    @Test
    void shouldCheckValueIsEven() {
         assertEquals(true,calc.isEven(2));
         assertEquals(false,calc.isEven(1));
    }

    @Test
    void shouldCheckValueIsOdd() {
         assertEquals(true,calc.isOdd(1));
         assertEquals(false,calc.isOdd(2));
    }


    @Test
    @DisplayName("Sum 2 encoded values")
    void shouldSumTwoEncodedValues() {

        // 1 + 2 = 3
         assertEquals(3, calc.sum(1,2) );
         assertEquals(9, calc.sum(5,4) );
         assertEquals(5, calc.sum(3,2) );
         assertEquals(14, calc.sum(5,9) );
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void shouldSumValueWithOne( int value ) {
        assertEquals(value + 1, calc.sum(value, 1));
    }

    @ParameterizedTest
    @MethodSource("sumInputValues")
    void shouldSumTwoInputValues(int a, int b) {
        assertEquals(a + b, calc.sum(a, b));
    }

    @ParameterizedTest
    @MethodSource("powerInputValues")
    void shouldComputePowerMethod (int base, int exponent, int answer) {
        assertEquals(answer, calc.power(base, exponent));
    }

    @ParameterizedTest
    @MethodSource("factorialValues")
        //I will mark this as a bonus since, ValueSource is not a proper way to test this
    void shouldComputeFactorial (int value, int ans) {
        assertEquals(ans, calc.factorial(value));
    }


    @ParameterizedTest
    @ValueSource(strings = {"civic","kayak","level","racecar","radar"})
    void shouldComputeFactorial (String value) {
        assertTrue(calc.isPalindrome(value));
    }


    @ParameterizedTest
    @MethodSource("arrayOfIntegerSets")
    void shouldOrderValues(int[] values) {
//        calc.displayValues(values);
        calc.bubbleSort(values);
//        calc.displayValues(values);
        assertTrue( calc.isSortedInAscending(values));
    }


    static Stream<Arguments> sumInputValues () {
        return Stream.of(
                Arguments.of(1,2),
                Arguments.of(4,6),
                Arguments.of(2,7),
                Arguments.of(3,7),
                Arguments.of(3,0)
        );
    }


    static Stream<Arguments> powerInputValues () {

        //1st parameter is the base, 2nd is the exponent, and 3rd is the answer
        return Stream.of(
                Arguments.of(2,2,4),
                Arguments.of(3,4,81),
                Arguments.of(2,7,128),
                Arguments.of(3,7,2187),
                Arguments.of(3,0,1)
        );
    }

    static Stream<Arguments> factorialValues () {

        //1st parameter is the value, 2nd is the answer
        return Stream.of(
                Arguments.of(2,2),
                Arguments.of(3,6),
                Arguments.of(7,5040),
                Arguments.of(0,1),
                Arguments.of(8,40320)
        );
    }

    static Stream<Arguments> arrayOfIntegerSets () {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,1}),
                Arguments.of(new int[]{7,1,5,4,1}),
                Arguments.of(new int[]{7,2,8,3,4})
        );
    }

}