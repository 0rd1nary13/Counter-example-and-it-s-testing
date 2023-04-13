//Rational class has denominator and numerator
//Rational class has methods to compute negation, reciprocal, compare two rational numbers for equality,
// compute sum of two rational numbers, and compute two rational numbers difference
//It also will compute the result of two rational numbers multiplication and division
//It also has a method to convert rational number to string

public class Rational {
    private int numerator;
    //denominator cannot be 0
    private int denominator;
    //defalt constructor initializes numerator and denominator to 1
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

    //compute reciprocal of rational number
    public Rational reciprocal() {
        return new Rational(denominator, numerator);
    }

    //compute sum of two rational numbers
    public Rational add(Rational rational) {
        int numerator = this.numerator * rational.denominator + this.denominator * rational.numerator;
        int denominator = this.denominator * rational.denominator;
        return new Rational(numerator, denominator);
    }

    //compute difference of two rational numbers
    public Rational subtract(Rational rational) {
        int numerator = this.numerator * rational.denominator - this.denominator * rational.numerator;
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
        return this.numerator * rational.denominator == this.denominator * rational.numerator;
    }

    //convert rational number to string
    public String toString() {
        return numerator + "/" + denominator;
    }
}
