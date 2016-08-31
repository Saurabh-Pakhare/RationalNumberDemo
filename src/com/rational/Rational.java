package com.rational;

/**
 * @author Saurabh Pakhare
 * @version 1.0
 */

public class Rational extends Number implements Comparable<Rational>{

    private long numerator;
    private long denominator;

    public Rational() {
        numerator = 0;
        denominator = 1;
    }

    public Rational(long numerator, long denominator) {

        if(denominator == 0)
            throw new ArithmeticException("Attempt to divide by zero");

        this.numerator = numerator;
        this.denominator = denominator;

        reduce(this);
    }

    @SuppressWarnings("unused")
    public long getNumerator() {
        return numerator;
    }

    @SuppressWarnings("unused")
    public long getDenominator() {
        return denominator;
    }

    /**
     *
     * @param secondNumber The other rational number operand
     * @return Addition of rational numbers
     */

    public Rational add(Rational secondNumber) {
        long commonDenominator = this.denominator * secondNumber.denominator;
        long numerator1 = this.numerator * secondNumber.denominator;
        long numerator2 = this.denominator * secondNumber.numerator;
        long sum = numerator1 + numerator2;

        Rational answer = new Rational(sum, commonDenominator);
        //reduce(answer);
        return answer;
    }

    /**
     *
     * @param secondNumber The other rational number operand
     * @return Subtraction of rational numbers
     */
    public Rational subtract(Rational secondNumber) {
        long commonDenominator = this.denominator * secondNumber.denominator;
        long numerator1 = this.numerator * secondNumber.denominator;
        long numerator2 = this.denominator * secondNumber.numerator;
        long diff = numerator1 - numerator2;

        Rational answer = new Rational(diff, commonDenominator);
        //reduce(answer);
        return answer;
    }

    /**
     *
     * @param secondNumber The other rational number operand
     * @return Multiplication of rational numbers
     */
    public Rational multiply(Rational secondNumber) {
        long newNumerator = this.numerator * secondNumber.numerator;
        long newDenominator = this.denominator * secondNumber.denominator;

        Rational answer = new Rational(newNumerator, newDenominator);
        //reduce(answer);
        return answer;
    }

    /**
     *
     * @param secondNumber
     * @return Division of rational numbers
     */
    public Rational divide(Rational secondNumber) {
        long newNumerator = this.numerator * secondNumber.denominator;
        long newDenominator = this.denominator * secondNumber.numerator;

        Rational answer = new Rational(newNumerator, newDenominator);
        //reduce(answer);
        return answer;
    }

    /**
     *
     * @param numerator
     * @param denominator
     * @return GCD of two numbers
     */
    @TestMe()
    private long gcd(long numerator, long denominator) {

        if (numerator == denominator)
            return numerator;

        if (numerator > denominator)
            return gcd(numerator - denominator, denominator);
        return gcd(numerator, denominator - numerator);
    }

    /**
     *
     * @param rationalNumber Reduced rational number
     */
    private void reduce(Rational rationalNumber) {
        long common = gcd(Math.abs(rationalNumber.numerator), rationalNumber.denominator);

        rationalNumber.numerator = rationalNumber.numerator/common;
        rationalNumber.denominator = rationalNumber.denominator/common;
    }

    @Override
    public String toString() {

        if (denominator == 1)
            return ""+numerator;

        return numerator+"/"+denominator;
    }

    @Override
    public int intValue() {
        return (int) (numerator/denominator);
    }

    @Override
    public long longValue() {
        return numerator/denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator/denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator/denominator;
    }

    @Override
    public int compareTo(Rational otherRationalNumber) {
        if (this.numerator == otherRationalNumber.numerator && this.denominator == otherRationalNumber.denominator)
        return 0;

        else
        {
            if (this.numerator >= otherRationalNumber.numerator && this.denominator <= otherRationalNumber.denominator)
                return 1;
            else
                return -1;
        }
    }
}
