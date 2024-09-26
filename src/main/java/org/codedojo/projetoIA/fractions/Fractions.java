package org.codedojo.projetoIA.fractions;

public class Fractions {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4);        
        Fraction result = f1.add(f2);
        System.out.println(result);


        Fraction f3 = new Fraction(3, 5);
        Fraction f4 = new Fraction(3, 5);        
        Fraction result2 = f3.add(f4);
        System.out.println(result2);

    }
}

class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    @Override
    public String toString() {
        if (numerator >= denominator) {
            int wholeNumber = numerator / denominator;
            int remainder = numerator % denominator;
            if (remainder == 0) {
                return String.valueOf(wholeNumber);
            } else {
                return wholeNumber + " " + remainder + "/" + denominator;
            }
        } else {
            return numerator + "/" + denominator;
        }
    }
}
