package com.andersen.rodionov.uilearning.bbc.chrome;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTests {

    @Test
    public void testAssertNumbers() {
        int x = 5;
        int y = 5;
        Assert.assertEquals(x, y, "Значение X != Значению Y");
    }

    @Test
    public void testAssertStringFull() {
        String x = "abcde";
        String y = "abcde";
        Assert.assertEquals(x, y, "Значение X != Значению Y");
    }

    @Test
    public void testAssertStringPart() {
        String x = "abcde";
        String y = "ab";
        Assert.assertTrue(x.contains(y), "Значение X не содержит Значение Y");
    }

    @Test
    public void testAssertArrays() {
        Integer[] array1 = {12, 34, 56, 77};
        Integer[] array2 = {77, 56, 34, 12};
        Assert.assertEqualsNoOrder(array1, array2, "Значения массивов не совпадают");
    }

    @Test
    public void testAssertArrayStrings() {
        String[] array1 = {"qwe", "rty", "uio"};
        String[] array2 = {"qwe", "rty", "uio"};
        Assert.assertEquals(array1, array2, "Значения массивов не совпадают");
    }

    @Test
    public void testSoftAssertNumbers() {

        SoftAssert softAssert = new SoftAssert();

        int x = 10;
        int y = 11;

        Integer[] array1 = {12, 34, 56, 77};
        Integer[] array2 = {12, 33, 1, 77};

        String a = "Russia";
        String b = "OR";

        softAssert.assertEquals(x,y,"Значение X != Значению Y");
        softAssert.assertEquals (array1,array2,"Значения массивов не совпадают");
        softAssert.assertTrue(a.contains(b),"Значение X не содержит Значение Y");

        softAssert.assertAll();
    }
}
