package cn.edu.hdu.acm.problem1009;


public class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private int numerator = 0;
    private int denominator = 1;
    private int gcd;

    /** Construct a rational with default properties */
    public Rational() {
        this(0, 1);
    }

    /** Construct a rational with specified numerator and denominator */
    public Rational(int numerator, int denominator) {
        this.gcd = gcd(numerator, denominator);
        this.numerator = ((denominator > 0) ? 1 : -1) * numerator;
        this.denominator = Math.abs(denominator);
    }

    /** Find GCD of two numbers */
    public static int gcd(int n, int d) {
        int n1 = Math.abs(n);
        int n2 = Math.abs(d);
        int gcd = 1;

        for (int k = 1; k <= n1 && k <= n2; k++) {
            if (n1 % k == 0 && n2 % k == 0)
                gcd = k;
        }

        return gcd;
    }

    /** Return numerator */
    public int getNumerator() {
        return numerator;
    }

    /** Return denominator */
    public int getDenominator() {
        return denominator;
    }

    /** Return numerator and denominator gcd */
    public int getGcd() {
        gcd = gcd(numerator, denominator);
        return gcd;
    }

    /** Add a rational number to this rational */
    public Rational add(Rational secondRational) {
        int n = numerator * secondRational.getDenominator() +
                denominator * secondRational.getNumerator();
        int d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /** Subtract a rational number from this rational */
    public Rational subtract(Rational secondRational) {
        int n = numerator * secondRational.getDenominator()
                - denominator * secondRational.getNumerator();
        int d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /** Multiply a rational number to this rational */
    public Rational multiply(Rational secondRational) {
        int n = numerator * secondRational.getNumerator();
        int d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /** Divide a rational number from this rational */
    public Rational divide(Rational secondRational) {
        int n = numerator * secondRational.getDenominator();
        int d = denominator * secondRational.numerator;
        return new Rational(n, d);
    }

    /** Override the toString() method */
    public String toString() {
        if (denominator == 1)
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    /** Override the equals method in the Object class */
    public boolean equals(Object parm1) {
        if ((this.subtract((Rational)(parm1))).getNumerator() == 0)
            return true;
        else
            return false;
    }

    /** Override the abstract intValue method in java.lang.Number */
    public int intValue() {
        return (int)doubleValue();
    }

    /** Override the abstract floatValue method in java.lang.Number */
    public float floatValue() {
        return (float)doubleValue();
    }

    /** Override the doubleValue method in java.lang.Number */
    public double doubleValue() {
        return numerator * 1.0 / denominator;
    }

    /** Override the abstract longValue method in java.lang.Number */
    public long longValue() {
        return (long)doubleValue();
    }

    @Override
    public int compareTo(Rational o) {
        if ((o.subtract(this)).getNumerator() > 0)
            return 1;
        else if ((o.subtract(this)).getNumerator() < 0)
            return -1;
        else
            return 0;
    }
}
