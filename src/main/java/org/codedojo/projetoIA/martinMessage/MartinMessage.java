package org.codedojo.projetoIA.martinMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * listar alfabeto em hexadecimal
 * 
 * Criar uma lista com as letras do alfabeto. Iterar sobre cada letra e converter para seu valor hexadecimal, utilizando dois numeros hexadecimais para representar o alfabeto, total de 16 numeros hexadecimais. Imprimir o resultado.
 * 
 * transformar uma mensagem em caracteres em uma sequencia hexadecimal
 * 
 * Ajustar a representação hexadecimal para usar dois dígitos.
 * 
 * distribuir os hexadecimais de 0x0 e 0xF em um angulo de 360 graus
 * 
 * cada hexadecimal corresponde a uma placa
 * 
 * pegar a frase de texte e imprimir a sequencia de placas
 * 
 * escrever o codigo em java
 * 
 * codigo não mostra a mensagem convertida
 * 
 * qual o erro que esta ocorrendo?
 * 
 * listar lista de caracteres ascii com o seu numero correspondente utilizando o par de hexadecimal
 * 
 * criar tdd para testar o MartinMessage
 */
public class MartinMessage {

    public static Map<String, Placa> distribuirHexadecimais() {
        // Lista com os valores hexadecimais de 0x00 a 0xFF
        String[] hexadecimais = new String[256];
        for (int i = 0; i < 256; i++) {
            hexadecimais[i] = String.format("%02X", i);
        }

        // Calcular o ângulo correspondente para cada valor hexadecimal
        double anguloPorHex = 360.0 / hexadecimais.length;

        // Criar um mapa para armazenar as placas
        Map<String, Placa> placas = new HashMap<>();
        for (int i = 0; i < hexadecimais.length; i++) {
            double angulo = i * anguloPorHex;
            placas.put(hexadecimais[i], new Placa(i + 1, angulo));
        }

        return placas;
    }

    public static void fraseParaPlacas(String frase) {
        // Obter o mapeamento de placas
        Map<String, Placa> placas = distribuirHexadecimais();

        // Iterar sobre cada caractere na frase
        for (char c : frase.toCharArray()) {
            // Converter o caractere para seu valor hexadecimal
            String hexVal = String.format("%02X", (int) c);

            // Obter a placa correspondente ao valor hexadecimal
            Placa placa = placas.get(hexVal);

            // Imprimir a placa se for válida
            if (placa != null) {
                System.out.printf("Placa: %d, Hexadecimal: 0x%s, Ângulo: %.2f graus%n",
                        placa.numero, hexVal, placa.angulo);
            }
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso
        String frase = "Hello, World!";
        fraseParaPlacas(frase);

        // Listar os caracteres ASCII com seus números correspondentes e valores hexadecimais
        listarAsciiHex();
    }

    public static class Placa {
        int numero;
        double angulo;

        Placa(int numero, double angulo) {
            this.numero = numero;
            this.angulo = angulo;
        }
    }

    public static void listarAsciiHex() {
        // Iterar sobre os valores ASCII de 0 a 127
        for (int i = 0; i < 128; i++) {
            // Converter o valor ASCII para seu caractere correspondente
            char caractere = (char) i;
            
            // Converter o valor ASCII para seu valor hexadecimal
            String hexVal = String.format("%02X", i);
            
            // Imprimir o caractere, seu valor ASCII e seu valor hexadecimal
            System.out.printf("Caractere: %c, ASCII: %d, Hexadecimal: 0x%s%n", caractere, i, hexVal);
        }
    }
}