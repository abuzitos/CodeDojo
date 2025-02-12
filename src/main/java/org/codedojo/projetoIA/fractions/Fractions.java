package org.codedojo.projetoIA.fractions;

/**
 * Classe principal para testar operações com frações.
 */
public class Fractions {
    public static void main(String[] args) {
        // Cria duas frações e as adiciona
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4);        
        Fraction result = f1.add(f2);
        System.out.println(result);

        // Cria outras duas frações e as adiciona
        Fraction f3 = new Fraction(3, 5);
        Fraction f4 = new Fraction(3, 5);        
        Fraction result2 = f3.add(f4);
        System.out.println(result2);
    }
}

/**
 * Classe que representa uma fração.
 */
class Fraction {
    private int numerator;
    private int denominator;

    /**
     * Construtor que inicializa a fração com numerador e denominador.
     * @param numerator o numerador da fração
     * @param denominator o denominador da fração
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominador não pode ser zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    /**
     * Adiciona esta fração a outra fração.
     * @param other a outra fração
     * @return uma nova fração que é a soma das duas frações
     */
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Simplifica a fração dividindo o numerador e o denominador pelo seu máximo divisor comum (MDC).
     */
    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    /**
     * Calcula o máximo divisor comum (MDC) usando o algoritmo de Euclides.
     * @param a um número inteiro
     * @param b outro número inteiro
     * @return o máximo divisor comum de a e b
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Retorna a representação em string da fração.
     * @return a fração como string
     */
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
