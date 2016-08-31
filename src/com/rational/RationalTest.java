package com.rational;
import org.junit.Assert;
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
           // Class<?> cls = Class.forName("Rational");
            Rational rational = new Rational();
            Method[] methods = rational.getClass().getMethods();
            long ans = 0;

            for (Method m : methods) {
                TestMe testMe = m.getAnnotation(TestMe.class);
                if (testMe != null) {
                    ans = (long) m.invoke(rationalOne, 1, 6);
                    assertEquals(1L, ans);
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
        rationalOne = new Rational(1, 6);
        rationalTwo = new Rational(3, 8);
    }

    @org.junit.Test
    public void add() throws Exception {
        assertEquals("13/24", rationalOne.add(rationalTwo).toString());
    }

    @org.junit.Test
    public void subtract() throws Exception {
        assertEquals("-5/24", rationalOne.subtract(rationalTwo).toString());
    }

    @org.junit.Test
    public void multiply() throws Exception {
        assertEquals("1/16", rationalOne.multiply(rationalTwo).toString());
    }

    @org.junit.Test
    public void divide() throws Exception {
        assertEquals("4/9", rationalOne.divide(rationalTwo).toString());
    }


}