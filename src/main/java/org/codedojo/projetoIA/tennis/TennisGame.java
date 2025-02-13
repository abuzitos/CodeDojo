package org.codedojo.projetoIA.tennis;

public class TennisGame {
    private int player1Points;
    private int player2Points;

    public TennisGame() {
        this.player1Points = 0;
        this.player2Points = 0;
    }

    public void addPointPlayer1() {
        player1Points++;
    }

    public void addPointPlayer2() {
        player2Points++;
    }

    public String getScore() {
        String[] scoreNames = {"Love", "Fifteen", "Thirty", "Forty"};

        if (player1Points >= 3 && player2Points >= 3) {
            if (player1Points == player2Points) {
                return "Deuce";
            } else if (player1Points == player2Points + 1) {
                return "Advantage Player 1";
            } else if (player2Points == player1Points + 1) {
                return "Advantage Player 2";
            }
        }

        if (player1Points >= 4 && player1Points >= player2Points + 2) {
            return "Game Player 1";
        } else if (player2Points >= 4 && player2Points >= player1Points + 2) {
            return "Game Player 2";
        }

        return scoreNames[player1Points] + " - " + scoreNames[player2Points];
    }

    // criar metodo main do jogo
    public static void main(String[] args) {
        TennisGame game = new TennisGame();
        game.addPointPlayer1();
        game.addPointPlayer1();
        game.addPointPlayer2();
        game.addPointPlayer2();
        game.addPointPlayer1();
        game.addPointPlayer2();
        game.addPointPlayer1();
        game.addPointPlayer1();
        System.out.println(game.getScore());
    }

}