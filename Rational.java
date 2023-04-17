/*
This project was completed at Apr 17 2023 by group "Better Call Stack"
with group member: Huiguang Ma, Linh Pham, Huiguang Ma(Jager is me), jaya singh and Vincent Xayasak.
*/

//Rational class has denominator and numerator

//Rational class has methods to compute negation, reciprocal, compare two rational numbers for equality,
// compute sum of two rational numbers, and compute two rational numbers difference
//It also will compute the result of two rational numbers multiplication and division
//It also has a method to convert rational number to string

public class Rational {
    private int numerator;
    //denominator cannot be 0
    private int denominator;
    //default constructor initializes numerator and denominator to 1
    public Rational() {
        this(1, 1);
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if(denominator != 0) {
            this.denominator = denominator;
        } else {
            throw new IllegalArgumentException("Denominator cannot be 0");
        }
    }

    //get numerator
    public int getNumerator() {
        return numerator;
    }

    //get denominator
    public int getDenominator() {
        return denominator;
    }

    //set numerator
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    //set denominator
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    //compute negation of rational number
    public Rational negate() {
        return new Rational(-numerator, denominator);
    }

    //Invert a rational number r
    public Rational invert() {
        return new Rational(denominator, numerator);
    }

    //compute reciprocal of rational number
    public Rational reciprocal() {
        return new Rational(denominator, numerator);
    }

    //compute sum of two rational numbers
    public Rational add(Rational rational) {
        int numerator = this.numerator * rational.denominator
                + this.denominator * rational.numerator;
        int denominator = this.denominator * rational.denominator;
        return new Rational(numerator, denominator);
    }

    //compute difference of two rational numbers
    public Rational subtract(Rational rational) {
        int numerator = this.numerator * rational.denominator
                - this.denominator * rational.numerator;
        int denominator = this.denominator * rational.denominator;
        return new Rational(numerator, denominator);
    }

    //compute multiplication of two rational numbers
    public Rational multiply(Rational rational) {
        int numerator = this.numerator * rational.numerator;
        int denominator = this.denominator * rational.denominator;
        return new Rational(numerator, denominator);
    }

    //compute division of two rational numbers
    public Rational divide(Rational rational) {
        int numerator = this.numerator * rational.denominator;
        int denominator = this.denominator * rational.numerator;
        return new Rational(numerator, denominator);
    }

    //compare two rational numbers for equality
    public boolean equals(Rational rational) {
        return this.numerator * rational.denominator
                == this.denominator * rational.numerator;
    }

    /*
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * is negative.
     *
     */
    private void normalize() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
    }

    /**
     * Recursively compute the greatest common divisor of two positive integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b)
    {
        int result = 0;
        if(a<b)
            result = gcd(b,a);
        else if(b==0)
            result = a;
        else
        {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }
}
