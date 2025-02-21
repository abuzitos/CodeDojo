package org.codedojo.projetoIA.diamond;

import java.util.Scanner;

public class DiamondInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Diamond diamond = new Diamond();

        System.out.print("Enter a letter to generate the diamond: ");
        char letter = scanner.next().charAt(0);

        String result = diamond.generateDiamond(letter);
        System.out.println(result);

        scanner.close();
    }
}
