package com.example.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class RandomTestClass {

    @Test
    public void onePlusOneIsTwo(){

        //Arrange
         int a=1;
         int b=1;
        //Act
          int x=a+b;
        //Assert
        //assert x==3;
        Assertions.assertEquals(2,x);
        Assertions.assertThrows(ArithmeticException.class,()->divideByZero());

        int[] input={4,5,3,2,1};
        int[] output={1,2,3,4,5};
        Arrays.sort(input);
        Assertions.assertArrayEquals(input,output);

        List<String> students1=Arrays.asList("ra","gh","hg");
        List<String> students2=Arrays.asList("ra","gh","hg");
        Assertions.assertLinesMatch(students1,students2);

        //timeout
        Assertions.assertTimeout(Duration.ofSeconds(2),()->maxSubarraySum(input));
    }

    public int maxSubarraySum(int[] numbers) throws InterruptedException {
        //Thread.sleep(3000);
        return 10;
    }
    public int divideByZero(){
        return 1/0;
    }
}
