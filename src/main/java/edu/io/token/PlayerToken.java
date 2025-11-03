package edu.io.token;

import edu.io.Board;
import edu.io.player.Player;

public class PlayerToken extends Token {
    public enum Move {
        NONE,
        LEFT,
        RIGHT,
        UP,
        DOWN,
    }

    private int row;
    private int col;
    private final Board board;
    private final Player player;

    public PlayerToken(Player player, Board board) {
        super(Label.PLAYER_TOKEN_LABEL);
        Board.Coords c = board.getAvailableSquare();
        if (c.col() < 0 || c.col() >= board.size || c.row() < 0 || c.row() >= board.size) {
            throw new IllegalArgumentException("Gracza nie ma na planszy");
        }
        this.row = c.row();
        this.col = c.col();
        this.board = board;
        this.player = player;
        board.placeToken(col, row, this);
    }

    public Board.Coords pos() {
        return new Board.Coords(row, col);
    }

    public void move(Move dir) {
        int newCol = this.col;
        int newRow = this.row;

        switch (dir) {
            case UP -> newRow--;
            case DOWN -> newRow++;
            case LEFT -> newCol--;
            case RIGHT -> newCol++;
            default -> {
                return;
            }
        }

        if (newCol < 0 || newCol >= board.size || newRow < 0 || newRow >= board.size) {
            throw new IllegalArgumentException("Nie mozna wyjsc poza plansze");
        }

        Token target = board.peekToken(newCol, newRow);
        player.interactWithToken(target);

        board.placeToken(this.col, this.row, new EmptyToken());
        this.col = newCol;
        this.row = newRow;
        board.placeToken(newCol, newRow, this);
    }

}
