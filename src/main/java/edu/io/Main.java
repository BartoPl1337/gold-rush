package edu.io;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Player player = new Player(7,7, board);

        board.placeToken(player.getCol(), player.getRow(), player.getToken());
        board.placeToken(5, 1, new Token("\uD83D\uDCB0"));
        board.placeToken(2, 3, new Token("\uD83D\uDCB0"));
        board.placeToken(3, 4, new Token("\uD83D\uDCB0"));
        board.placeToken(7, 6, new Token("\uD83D\uDCB0"));

        while (true) {
            board.display();
            System.out.println("Zebrane zloto: " + player.getGold());
            System.out.print("Ruch(w/a/s/d, q - koniec): ");
            String ruch = scanner.nextLine();

            if (ruch.equals("q")) {
                break;
            }
            player.movePlayer(board, ruch.charAt(0));
        }

        scanner.close();
    }
}
