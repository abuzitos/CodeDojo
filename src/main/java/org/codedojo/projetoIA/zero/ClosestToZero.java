package org.codedojo.projetoIA.zero;

public class ClosestToZero {
    // Dado uma lista de inteiros, encontre o mais próximo de zero. Se houver empate, escolha o valor positivo.

    public int closestToZero(int[] ints) {
        // Inicializa a variável 'closest' com o maior valor inteiro possível
        int closest = Integer.MAX_VALUE;
        // Itera sobre cada inteiro no array 'ints'
        for (int i = 0; i < ints.length; i++) {
            // Se o valor absoluto do inteiro atual é menor que o valor absoluto de 'closest'
            if (Math.abs(ints[i]) < Math.abs(closest)) {
                // Atualiza 'closest' para o inteiro atual
                closest = ints[i];
            // Se o valor absoluto do inteiro atual é igual ao valor absoluto de 'closest' e o inteiro atual é positivo
            } else if (Math.abs(ints[i]) == Math.abs(closest) && ints[i] > closest) {
                // Atualiza 'closest' para o inteiro atual
                closest = ints[i];
            }
        }
        // Retorna o valor mais próximo de zero
        return closest;
    }

    // Cria um método main que permite testar a classe ClosestToZero
    public static void main(String[] args) {
        // Instancia a classe ClosestToZero
        ClosestToZero closestToZero = new ClosestToZero();
        // Define um array de inteiros para teste
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Imprime o resultado do método closestToZero
        System.out.println(closestToZero.closestToZero(ints));
    }
}
