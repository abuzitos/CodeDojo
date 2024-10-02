package org.codedojo.projetoIA.montyHall;

import java.util.Random;

public class MontyHall {

    public static final int TOTAL_GAMES = 1000;
    public static final Random random = new Random();

    public static void main(String[] args) {
        int switchWins = runSimulation(true);
        int stayWins = runSimulation(false);

        System.out.println("Switching strategy wins: " + switchWins + " out of " + TOTAL_GAMES);
        System.out.println("Staying strategy wins: " + stayWins + " out of " + TOTAL_GAMES);
    }

    public static int runSimulation(boolean switchChoice) {
        int wins = 0;
        for (int i = 0; i < TOTAL_GAMES; i++) {
            if (simulateGame(switchChoice)) {
                wins++;
            }
        }
        return wins;
    }

    public static boolean simulateGame(boolean switchChoice) {
        int carDoor = random.nextInt(3);
        int playerChoice = random.nextInt(3);

        // Host opens a door with a goat
        int hostChoice;
        do {
            hostChoice = random.nextInt(3);
        } while (hostChoice == carDoor || hostChoice == playerChoice);

        // Player switches choice if switchChoice is true
        if (switchChoice) {
            playerChoice = 3 - playerChoice - hostChoice;
        }

        return playerChoice == carDoor;
    }
}
