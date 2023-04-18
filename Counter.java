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
//overload constructor also simplifies rational number

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ZeroDenominatorException("Denominator cannot be 0");
        }else if(numerator < 0 && denominator < 0){
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }else if(denominator < 0){
            numerator = -numerator;
            denominator = Math.abs(denominator);
        }
        this.numerator = numerator;
        this.denominator = denominator;
        normalize();
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

// Sample Run at RationalTest
/*/Users/jagerforest/Library/Java/JavaVirtualMachines/openjdk-20/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=50651:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/jagerforest/IdeaProjects/_666/out/production/_666 RationalTest
TESTING the constructor, getNumerator, getDenominator
Trying default constructor
 Passes
 Passes
Constructing 2/5
 Passes
 Passes
 Passes
Trying 2/0
 Passes
Trying 42/30
 Passes
 Passes
Trying 6/-3
 Passes
 Passes
Trying -6/-3
 Passes
 Passes
Trying -6/3
 Passes
 Passes
Trying 0/3
 Passes
 Passes
Constructor tests finished


TESTING the negate method
Negate 1/2
 Passes
 Passes
 Passes
 Passes
Negate -2/3
 Passes
 Passes
 Passes
 Passes
Negate tests finished


TESTING the invert method
Invert 1/2
 Passes
 Passes
 Passes
 Passes
Invert -2/3
 Passes
 Passes
 Passes
 Passes
Invert 0/5
 Passes
Invert tests finished


TESTING the add and subtract methods
Adding 1/2 and 1/2
 Passes
 Passes
 Passes
 Passes
Adding 4/7 and 3/5
 Passes
 Passes
 Passes
 Passes
 Passes
 Passes
Adding 1/2 and 1/6
 Passes
 Passes
Subtracting 1/2 and 1/2
 Passes
 Passes
 Passes
 Passes
Subtracting 4/7 and 3/5
 Passes
 Passes
 Passes
 Passes
 Passes
 Passes
Subtracting 1/2 and 1/6
 Passes
 Passes
Add/Subtract tests finished


TESTING the multiply and divide methods
Multiply 1/2 and 1/2
 Passes
 Passes
 Passes
 Passes
Multiply 5/7 and 3/5
 Passes
 Passes
 Passes
 Passes
 Passes
 Passes
Multiply 1/2 and 0/1
 Passes
 Passes
Dividing 1/2 by 1/2
 Passes
 Passes
 Passes
 Passes
Dividing 4/7 by 3/28
 Passes
 Passes
 Passes
 Passes
 Passes
 Passes
Dividing 1/2 by 1/6
 Passes
 Passes
Dividing 1/2 by 0/1
 Passes
Multiply/Divide tests finished

Process finished with exit code 0
*/
