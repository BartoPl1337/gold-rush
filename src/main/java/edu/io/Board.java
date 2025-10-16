package edu.io;

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

    public void clean() {
//        Token empty = new Token("\u30FB");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Token("\u30FB");
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
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public void movePlayer(int row, int col, Player player) {
        if (col < 0 || col >= size || row < 0 || row >= size) {
           System.out.println("Nie mozna wyjsc poza plansze");
           return;
        }
        Token token = grid[row][col];
        if(token.label().equals("\uD83D\uDCB0")){
            player.addGold(1);
        }

        grid[player.getRow()][player.getCol()] = new Token("\u30FB");
        player.setPosition(row, col);
        grid[row][col] = player.getToken();
    }
}
