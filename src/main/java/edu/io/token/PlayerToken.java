package edu.io.token;

import edu.io.Board;

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
    private int gold;
    private final Board board;

    public PlayerToken(Board board, int row, int col) {
        super(Label.PLAYER_TOKEN_LABEL);
        if (col < 0 || col >= board.size || row < 0 || row >= board.size) {
            System.out.println("Gracza nie ma na planszy");
        }
        this.row = row;
        this.col = col;
        this.gold = 0;
        this.board = board;
        board.placeToken(col, row, this);
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getGold() {
        return gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public Board.Coords pos() {
        return new Board.Coords(row, col);
    }

    public void move(Move dir) {
        int col = this.col;
        int row = this.row;
        try {

            switch (dir) {
                case Move.DOWN:
                    row++;
                    break;
                case Move.UP:
                    row--;
                    break;
                case Move.RIGHT:
                    col++;
                    break;
                case Move.LEFT:
                    col--;
                    break;
                case Move.NONE:
                    return;
                default:
                    System.out.println("Zly przycisk");
                    return;
            }
            if (col < 0 || col >= board.size || row < 0 || row >= board.size) {
                throw new IllegalArgumentException("Cannot move outside of board");
            }
            board.placeToken(col, row, new EmptyToken());
            this.col = col;
            this.row = row;
            board.placeToken(this.row, this.col, this);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
