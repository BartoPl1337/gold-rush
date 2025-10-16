package edu.io;

public class Player {
    private final Token token = new Token("\uC6C3");
    private int row;
    private int col;
    private int gold;

    public Player(int row, int col, Board board) {
        if (row < 0 || row >= board.size || col < 0 || col >= board.size) {
            System.out.println("Niepoprawne wartosci gracza nie ma na planszy");
        }
        this.row = row;
        this.col = col;
        this.gold = 0;
    }

    public Token getToken() {
        return token;
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

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void movePlayer(Board board, char where) {
        int col = this.col;
        int row = this.row;

        switch (where) {
            case 's':
                row++;
                break;
            case 'w':
                row--;
                break;
            case 'd':
                col++;
                break;
            case 'a':
                col--;
                break;
            default:
                System.out.println("Zly przycisk");
                return;
        }
        board.movePlayer(row, col, this);
    }
}
