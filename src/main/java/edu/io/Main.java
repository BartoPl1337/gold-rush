package edu.io;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Gold Rush");
//        Board board = new Board(8);
        Board board = new Board();
        Token gold = new Token("\uD83D\uDCB0");
        Token player = new Token("\uC6C3");

        board.placeToken(2, 2, gold);
        board.placeToken(1, 5, player);

        board.display();
    }
}
