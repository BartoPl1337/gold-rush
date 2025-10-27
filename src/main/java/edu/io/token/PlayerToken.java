package edu.io.token;

import edu.io.Board;
import edu.io.Player;

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
        if (col < 0 || col >= board.size || row < 0 || row >= board.size) {
            System.out.println("Gracza nie ma na planszy");
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
            player.interactWithToken(board.peekToken(col, row));

            board.placeToken(this.col, this.row, new EmptyToken());
            this.col = col;
            this.row = row;
            board.placeToken(col, row, this);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
