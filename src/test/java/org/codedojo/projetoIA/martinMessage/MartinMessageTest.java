package org.codedojo.projetoIA.martinMessage;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MartinMessageTest {

    @Test
    public void testDistribuirHexadecimais() {
        // Testar se a distribuição de hexadecimais está correta
        Map<String, MartinMessage.Placa> placas = MartinMessage.distribuirHexadecimais();
        assertNotNull(placas);
        assertEquals(256, placas.size());
        
        // Verificar alguns valores específicos
        assertTrue(placas.containsKey("00"));
        assertTrue(placas.containsKey("0F"));
        assertTrue(placas.containsKey("FF"));
        
        MartinMessage.Placa placa00 = placas.get("00");
        assertEquals(1, placa00.numero);
        assertEquals(0.0, placa00.angulo, 0.01);
        
        MartinMessage.Placa placaFF = placas.get("FF");
        assertEquals(256, placaFF.numero);
        assertEquals(360.0 - (360.0 / 256), placaFF.angulo, 0.01);
    }

    @Test
    public void testFraseParaPlacas() {
        // Redirecionar a saída padrão para capturar a saída do método
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Testar a conversão de uma frase para placas
        String frase = "Hello";
        MartinMessage.fraseParaPlacas(frase);
        
        // Verificar a saída
        String expectedOutput = 
            """
            Placa: 73, Hexadecimal: 0x48, \u00c2ngulo: 101.25 graus
            Placa: 102, Hexadecimal: 0x65, \u00c2ngulo: 142.03 graus
            Placa: 109, Hexadecimal: 0x6C, \u00c2ngulo: 151.88 graus
            Placa: 109, Hexadecimal: 0x6C, \u00c2ngulo: 151.88 graus
            Placa: 112, Hexadecimal: 0x6F, \u00c2ngulo: 156.09 graus
            """;
        
        assertEquals(expectedOutput, outContent.toString());
        
        // Restaurar a saída padrão
        System.setOut(System.out);
    }
}