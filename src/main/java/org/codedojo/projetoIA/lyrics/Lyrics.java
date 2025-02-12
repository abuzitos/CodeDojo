package org.codedojo.projetoIA.lyrics;

import java.util.ArrayList;
import java.util.List;

public class Lyrics {
    

    // criar um algoritmo que faça:
    //
    // Input:
    //      - On the first day of Christmas
    //      - My true love sent to me:
    //      - A partridge in a pear tree.
    //
    //      - On the second day of Christmas
    //      - Two turtle doves and
    //
    //      - On the third day of Christmas
    //      - Three french hens
    //
    //      - On the fourth day of Christmas
    //      - Four calling birds
    //
    //      - On the fifth day of Christmas
    //      - Five golden rings
    //
    //      - On the sixth day of Christmas,
    //      - Six geese a-laying
    //
    //      - On the seventh day of Christmas,
    //      - Seven swans a-swimming
    //
    //      - On the eight day of Christmas,
    //      - Eight maids a-milking
    //
    //      - On the ninth day of Christmas,
    //      - Nine ladies dancing
    //
    //      - On the tenth day of Christmas,
    //      - Ten lords a-leaping
    //
    //      - On the eleventh day of Christmas,
    //      - Eleven pipers piping
    //
    //      - On the twelfth day of Christmas,
    //      - Twelve drummers drumming
    //
    // Processamento:
    //      - Adicionar os grupos sempre no topo do array e a partir da segunda linha
    //
    // Output:
    //      - Mostrar os textos adicionados conforme a sua adição no array
    //

    public static void main(String[] args) {
        // Definir os versos para cada dia do Natal
        String[] versos = {
            "A partridge in a pear tree.",
            "Two turtle doves and",
            "Three french hens",
            "Four calling birds",
            "Five golden rings",
            "Six geese a-laying",
            "Seven swans a-swimming",
            "Eight maids a-milking",
            "Nine ladies dancing",
            "Ten lords a-leaping",
            "Eleven pipers piping",
            "Twelve drummers drumming"
        };

        // Inicializar uma lista para armazenar os versos do canto
        List<String> cancoes = new ArrayList<>();

        // Iterar pelos dias do Natal
        for (int dia = 0; dia < 12; dia++) {
            // Adicionar o novo verso no topo da lista
            cancoes.add(0, versos[dia]);

            // Construir a saída para o dia atual
            StringBuilder saida = new StringBuilder();
            saida.append("On the ").append(getOrdinal(dia + 1)).append(" day of Christmas\n");
            saida.append("My true love sent to me:\n");
            for (String verso : cancoes) {
            saida.append(verso).append("\n");
            }

            // Imprimir a saída
            System.out.print(saida.toString());
            System.out.println();  // Imprimir uma nova linha para melhor legibilidade
        }
    }

    private static String getOrdinal(int number) {
        switch (number) {
            case 1:
                return "first";
            case 2:
                return "second";
            case 3:
                return "third";
            case 4:
                return "fourth";
            case 5:
                return "fifth";
            case 6:
                return "sixth";
            case 7:
                return "seventh";
            case 8:
                return "eighth";
            case 9:
                return "ninth";
            case 10:
                return "tenth";
            case 11:
                return "eleventh";
            case 12:
                return "twelfth";
            default:
                return "";
        }
    }
}