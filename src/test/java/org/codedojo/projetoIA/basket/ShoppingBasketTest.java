package org.codedojo.projetoIA.basket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingBasketTest {
    private ShoppingBasket basket;

    /**
     * Sets up the test environment before each test case.
     * Initializes a new ShoppingBasket instance and adds three items to it:
     * - Item A with a price of 10.0 and quantity of 5
     * - Item B with a price of 25.0 and quantity of 2
     * - Item C with a price of 9.99 and quantity of 6
     */
    @BeforeEach
    public void setUp() {
        basket = new ShoppingBasket();
        basket.addItem(new Item("Item A", 10.0, 5));
        basket.addItem(new Item("Item B", 25.0, 2));
        basket.addItem(new Item("Item C", 9.99, 6));
    }

    /**
     * Tests the getQuantity method of the ShoppingBasket class.
     * 
     * This test verifies that the getQuantity method returns the correct quantity
     * for various items in the basket. It checks the following scenarios:
     * - Item A has a quantity of 5.
     * - Item B has a quantity of 2.
     * - Item C has a quantity of 6.
     * - Item D is not in the basket and should return a quantity of 0.
     */
    @Test
    public void testGetQuantity() {
        assertEquals(5, basket.getQuantity("Item A"));
        assertEquals(2, basket.getQuantity("Item B"));
        assertEquals(6, basket.getQuantity("Item C"));
        assertEquals(0, basket.getQuantity("Item D")); // Item not in basket
    }

    @Test
    public void testCalculateTotalPrice() {
        double expectedTotal = (10.0 * 5) + (25.0 * 2) + (9.99 * 6);
        expectedTotal *= 0.95; // Apply 5% discount
        assertEquals(expectedTotal, basket.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testCalculateTotalPriceWithNoDiscount() {
        ShoppingBasket smallBasket = new ShoppingBasket();
        smallBasket.addItem(new Item("Item D", 10.0, 1));
        assertEquals(10.0, smallBasket.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testCalculateTotalPriceWith10PercentDiscount() {
        ShoppingBasket largeBasket = new ShoppingBasket();
        largeBasket.addItem(new Item("Item E", 100.0, 3));
        double expectedTotal = 100.0 * 3 * 0.90; // Apply 10% discount
        assertEquals(expectedTotal, largeBasket.calculateTotalPrice(), 0.01);
    }

    // Criar um test que calcula o total de um carrinho de compras vazio
    @Test
    public void testCalculateTotalPriceWithEmptyBasket() {
        ShoppingBasket emptyBasket = new ShoppingBasket();
        assertEquals(0.0, emptyBasket.calculateTotalPrice(), 0.01);
    }
}