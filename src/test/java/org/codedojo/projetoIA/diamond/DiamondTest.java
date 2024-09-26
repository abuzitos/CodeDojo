package org.codedojo.projetoIA.diamond;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DiamondTest {

    @Test
    public void testDiamondOutput() {
        Diamond diamond = new Diamond();
        String expectedOutputE = 
            """
                A
               B B
              C   C
             D     D
            E       E
             D     D
              C   C
               B B
                A
            """;
        assertEquals(expectedOutputE, diamond.generateDiamond('E'));

        String expectedOutputC = 
            """
              A
             B B
            C   C
             B B
              A
            """;
        assertEquals(expectedOutputC, diamond.generateDiamond('C'));
    }
}