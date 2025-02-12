package org.codedojo.projetoIA.fractions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para a classe Fractions.
 */
public class FractionsTest {

    /**
     * Cenário: Adicionar duas frações
     * Dado que eu tenho uma fração 1/2
     * E eu tenho uma fração 1/3
     * Quando eu adiciono as duas frações
     * Então o resultado deve ser 5/6
     */
    @Test
    public void testAddition() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction result = f1.add(f2);
        assertEquals("5/6", result.toString());
    }

    /**
     * Cenário: Simplificar uma fração
     * Dado que eu tenho uma fração 2/4
     * Quando a fração é simplificada
     * Então o resultado deve ser 1/2
     */
    @Test
    public void testSimplification() {
        Fraction f = new Fraction(2, 4);
        assertEquals("1/2", f.toString());
    }

    /**
     * Cenário: Criar uma fração com denominador zero
     * Dado que eu tento criar uma fração com denominador zero
     * Quando a fração é criada
     * Então deve lançar uma exceção IllegalArgumentException
     * E a mensagem deve ser "Denominador não pode ser zero"
     */
    @Test
    public void testZeroDenominator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Fraction(1, 0);
        });
        assertEquals("Denominador não pode ser zero", exception.getMessage());
    }

    /**
     * Cenário: Tipos de dados como inteiros
     * Dado que eu tenho uma fração com numerador e denominador inteiros
     * Quando a fração é criada
     * Então a fração deve ser válida
     */
    @Test
    public void testIntegerTypes() {
        Fraction f = new Fraction(2, 3);
        assertEquals("2/3", f.toString());
    }

    /**
     * Cenário: Valores nulos
     * Dado que eu tento adicionar uma fração nula
     * Quando a operação de adição é realizada
     * Então deve lançar uma exceção NullPointerException
     */
    @Test
    public void testNullValues() {
        Fraction f1 = new Fraction(1, 2);
        Exception exception = assertThrows(NullPointerException.class, () -> {
            f1.add(null);
        });
        assertEquals("Cannot invoke \"org.codedojo.projetoIA.fractions.Fraction.getDenominator()\" because \"other\" is null", exception.getMessage());
    }

    /**
     * Cenário: Retorno de exceções
     * Dado que eu tento criar uma fração com denominador zero
     * Quando a fração é criada
     * Então deve lançar uma exceção IllegalArgumentException
     */
    @Test
    public void testExceptionReturn() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Fraction(1, 0);
        });
        assertEquals("Denominador não pode ser zero", exception.getMessage());
    }

    /**
     * Cenário: Casos positivos
     * Dado que eu tenho duas frações positivas
     * Quando eu adiciono as duas frações
     * Então o resultado deve ser uma fração positiva
     */
    @Test
    public void testPositiveCases() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction result = f1.add(f2);
        assertEquals("5/6", result.toString());
    }

    /**
     * Cenário: Casos negativos
     * Dado que eu tenho uma fração negativa e uma positiva
     * Quando eu adiciono as duas frações
     * Então o resultado deve ser uma fração negativa ou zero
     */
    @Test
    public void testNegativeCases() {
        Fraction f1 = new Fraction(-1, 2);
        Fraction f2 = new Fraction(1, 2);
        Fraction result = f1.add(f2);
        assertEquals("0", result.toString());
    }
}
