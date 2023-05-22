//https://github.com/ZerAuX12/ecpe205-unit-test
package com.ecpe205;

public class Calculator {
    public double sum( double a, double b ) {
        return a + b;
    }

    public boolean isEven (int value) {
        return value % 2 == 0;
    }
    public boolean isOdd (int value) {
        return value % 2 == 1;
    }

    //create a method that computes base x power of y
    //use parameterizedTest methodsource - 5 sets to test

    public double power(int base, int exponent) {
        return Math.pow(base, exponent);
    }


    //create a method that computes for the factorial of a value
    //use parameterizedTest- 5 values to test


    public double factorial(int value) {
        if (value == 0)
            return 1;
        else
            return(value * factorial(value-1));
    }

    //create a method that checks if a given string is a palindrome
    //use parameterizedTest - 5 values to test

    public boolean isPalindrome(String word) {
        StringBuilder builder = new StringBuilder();
        builder.append(word);

        return word.equals(builder.reverse().toString());
    }

    //create a method that accepts an array of integer values, the method then sorts the value in ascending order
    //** you may choose whatever sort data structure (bubble sort, shell sort,...)
    //use parameterizedTest methodSource

    public void bubbleSort(int[] values) {
        for (int i=0; i < values.length-1 ;i++){
            for(int j=0 ; j< values.length-i - 1; j++){

                if(values[j+1] < values[j]){
                    int swap = values[j];
                    values[j] = values[j+1];
                    values[j+1] = swap;
                }
            }
        }
    }

    public void displayValues(int[] values) {
        for (int i : values ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public boolean isSortedInAscending(int[] values) {
        for ( int i = 0; i < values.length - 1 ; i++ ) {
            if ( values[i] > values[i + 1] ) {
                return false;
            }
        }

        return true;

    }
}
