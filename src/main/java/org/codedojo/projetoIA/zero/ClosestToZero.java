package org.codedojo.projetoIA.zero;

public class ClosestToZero {
    // Given a list of integers find the closest to zero. If there is a tie, choose the positive value.

    public int closestToZero(int[] ints) {
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < ints.length; i++) {
            if (Math.abs(ints[i]) < Math.abs(closest)) {
                closest = ints[i];
            } else if (Math.abs(ints[i]) == Math.abs(closest) && ints[i] > closest) {
                closest = ints[i];
            }
        }
        return closest;
    }

    // Crear um mathodo main que permite testar a classe ClosestToZero
    public static void main(String[] args) {
        ClosestToZero closestToZero = new ClosestToZero();
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(closestToZero.closestToZero(ints));
    }
}
