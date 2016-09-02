package com.rational;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by saurabh on 31/8/16.
 */
public class RationalTest {

    Rational rationalOne;
    Rational rationalTwo;

    @Test
    public void checkTestMeAnnotation() {
        try {

            Rational rational = new Rational();
            Method[] methods = rational.getClass().getDeclaredMethods();
            long ans = 0;

            for (Method m : methods) {
                TestMe testMe = m.getAnnotation(TestMe.class);
                if (testMe != null) {
                    m.setAccessible(true);
                    ans = (long) m.invoke(rationalOne, 2, 4);
                    assertEquals(2L, ans);
                    System.out.println(ans);
                }
            }



        } catch (InvocationTargetException e) {
            e.getMessage();
        } catch (IllegalAccessException e) {
            e.getMessage();
        }
    }

    @Before
    public void initialize() {
        rationalOne = new Rational(2, 2);
        rationalTwo = new Rational(1, 2);

        //System.out.println(rationalOne);
    }

    @org.junit.Test
    public void add() throws Exception {
        assertEquals("3/2", rationalOne.add(rationalTwo).toString());
    }

    @org.junit.Test
    public void subtract() throws Exception {
        assertEquals("1/2", rationalOne.subtract(rationalTwo).toString());
    }

    @org.junit.Test
    public void multiply() throws Exception {
        assertEquals("1/2", rationalOne.multiply(rationalTwo).toString());
    }

    @org.junit.Test
    public void divide() throws Exception {
        assertEquals("2", rationalOne.divide(rationalTwo).toString());
    }


}