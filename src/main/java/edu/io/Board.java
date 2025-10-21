package edu.io;

import edu.io.token.EmptyToken;
import edu.io.token.PlayerToken;
import edu.io.token.Token;

public class Board {
    public final int size;
    public final Token[][] grid;

    public Board() {
        this(8);
    }

    public Board(int size) {
        this.size = size;
        this.grid = new Token[size][size];
        clean();
    }

    public record Coords(int row, int col) {
    }

    public void clean() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = new EmptyToken();
            }
        }
    }

    public void placeToken(int col, int row, Token token) {
        if (col >= 0 && col < size && row >= 0 && row < size) {
            grid[row][col] = token;
        }
    }

    public Token square(int col, int row) {
        if (col >= 0 && col < size && row >= 0 && row < size) {
            return grid[row][col];
        }
        return null;
    }

    public void display() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }
    }
}
