package org.codedojo.projetoIA.diamond;

public class Diamond {
    /**
     * Generates a diamond shape pattern with the given letter at its widest point.
     * The diamond starts with 'A' at the top and expands outwards to the given
     * letter.
     * 
     * For example, if the input letter is 'C', the output will be:
     * 
     * A
     * B B
     * C C
     * B B
     * A A
     * B B
     * C C
     * B B
     * A
     * 
     * @param letter the letter at the widest point of the diamond
     * @return a string representing the diamond shape pattern
     */
    public String generateDiamond(char letter) {
        int size = letter - 'A' + 1;
        StringBuilder diamond = new StringBuilder();

        // Generate the top half of the diamond
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                diamond.append(" ");
            }
            diamond.append((char) ('A' + i));
            if (i > 0) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    diamond.append(" ");
                }
                diamond.append((char) ('A' + i));
            }
            diamond.append("\n");
        }

        // Generate the bottom half of the diamond
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j < size - i - 1; j++) {
                diamond.append(" ");
            }
            diamond.append((char) ('A' + i));
            if (i > 0) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    diamond.append(" ");
                }
                diamond.append((char) ('A' + i));
            }
            diamond.append("\n");
        }

        return diamond.toString();
    }

    public static void main(String[] args) {
        Diamond diamond = new Diamond();
        System.out.println(diamond.generateDiamond('E'));
        System.out.println(diamond.generateDiamond('C'));
    }
}
