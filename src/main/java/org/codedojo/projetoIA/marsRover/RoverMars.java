package org.codedojo.projetoIA.marsRover;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Etapa 01:
 * 
 * Array que representa "Rover Mars", cada elemento do array deve ter o seu numero, posição X e Y e uma letra que representa os pontos cardeais da bussola (N, S, L, O)
 *
 * Entrada de dados para movimentar o "Rover Mars", os dados são separados por um espaço. Exemplo: numero do rover, Ponto Cardeal que o Rover vai estar apontando, e M (numero de casas que ele deve andar)
 *
 * Output de dados: Listar todos os rovers com o valor anterior e o novo valor após recever a entrada de dados
 *
 * Etapa 02:
 * 
 * desejo entrar com os dados de movimentação do rover
 * 
 * Etapa 03:
 * 
 * todos os rover devem sempre ser iniciados em X = 0, Y = 0, N
 * 
 * Etapa 04:
 * 
 * Após a entrada de dados, a posição do rover deve ser atualizada
 *
 * Rover: 1, Posição: N, X = 0, Y = 0
 * 
 * Input: 1 L 5 Output Desejado: Rover 1: (5, 0) L Output Atual: Rover 1: (5, 0) N
 * 
 * Etapa 05:
 * 
 * na entrada de dados, a palavra "lista" deve listar todos os dados dos rovers
 * 
 * Etapa 06:
 * 
 * escrever tdd para testar a classe Rover
 */

class Rover {
    private int number;
    private int x;
    private int y;
    private char direction;
    
    public Rover(int number) {
        this.number = number;
        this.x = 0;
        this.y = 0;
        this.direction = 'N';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void move(char direction, int steps) {
        this.direction = direction; // Atualiza a direção do rover
        switch (direction) {
            case 'N' -> this.y += steps;
            case 'S' -> this.y -= steps;
            case 'L' -> this.x += steps;
            case 'O' -> this.x -= steps;
        }
    }

    @Override
    public String toString() {
        return "Rover " + number + ": (" + x + ", " + y + ") " + direction;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

public class RoverMars {
    private static final List<Rover> rovers = new ArrayList<>();

    public static void main(String[] args) {
        // Inicializa a lista de rovers com todos começando em (0, 0, 'N')
        for (int i = 1; i <= 4; i++) {
            rovers.add(new Rover(i));
        }

        try ( // Ler dados de movimentação do usuário
                Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite os comandos de movimentação (formato: numero_rover direção passos), 'lista' para listar todos os rovers, ou 'sair' para terminar:");
            
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("sair")) {
                    break;
                } else if (input.equalsIgnoreCase("lista")) {
                    listRovers();
                } else {
                    processInput(input);
                }
            }
        }
    }

    private static void processInput(String inputData) {
        String[] parts = inputData.split(" ");
        int number = Integer.parseInt(parts[0]);
        char direction = parts[1].charAt(0);
        int steps = Integer.parseInt(parts[2]);

        Rover rover = rovers.stream()
                            .filter(r -> r.getNumber() == number)
                            .findFirst()
                            .orElse(null);

        if (rover != null) {
            System.out.println("Before: " + rover);
            rover.move(direction, steps);
            System.out.println("After: " + rover);
        } else {
            System.out.println("Rover com número " + number + " não encontrado.");
        }
    }

    private static void listRovers() {
        for (Rover rover : rovers) {
            System.out.println(rover);
        }
    }
}