package org.codedojo.projetoIA.liftButton;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Criar uma classe de teste chamada LiftButtonTest.
 * Escrever métodos de teste para cada cenário:
 * Pressionar o botão quando a luz está apagada e as portas estão fechadas.
 * Pressionar o botão quando a luz está acesa e as portas estão fechadas.
 * Pressionar o botão quando as portas estão abertas.
 * Verificar se a luz apaga quando o elevador chega.
 * Verificar se as portas fecham corretamente.
 */

public class LiftButtonTest {

    @Test
    public void testPressButtonWhenLightOffAndDoorsClosed() {
        LiftButton liftButton = new LiftButton();
        liftButton.pressButton();
        assertTrue(liftButton.isLightOn(), "Light should be on after pressing the button when doors are closed and light is off.");
    }

    @Test
    public void testPressButtonWhenLightOnAndDoorsClosed() {
        LiftButton liftButton = new LiftButton();
        liftButton.pressButton(); // Turn the light on
        liftButton.pressButton(); // Press again
        assertTrue(liftButton.isLightOn(), "Light should remain on after pressing the button again when doors are closed and light is on.");
    }

    @Test
    public void testPressButtonWhenDoorsOpen() {
        LiftButton liftButton = new LiftButton();
        liftButton.liftArrives(); // Open the doors
        liftButton.pressButton(); // Try to press the button
        assertFalse(liftButton.isLightOn(), "Light should remain off when pressing the button while doors are open.");
    }

    @Test
    public void testLiftArrives() {
        LiftButton liftButton = new LiftButton();
        liftButton.pressButton(); // Turn the light on
        liftButton.liftArrives(); // Lift arrives and doors open
        assertFalse(liftButton.isLightOn(), "Light should be off when the lift arrives and doors open.");
        assertTrue(liftButton.areDoorsOpen(), "Doors should be open when the lift arrives.");
    }

    @Test
    public void testDoorsClose() {
        LiftButton liftButton = new LiftButton();
        liftButton.liftArrives(); // Open the doors
        liftButton.doorsClose(); // Close the doors
        assertFalse(liftButton.areDoorsOpen(), "Doors should be closed after calling doorsClose.");
    }
}
