package edu.io;

import edu.io.token.GoldToken;
import edu.io.token.PlayerToken;
import edu.io.token.Token;

public class Player {
    private PlayerToken token;
    private double gold = 0.0;

    public void assignToken(PlayerToken token) {
        this.token = token;
    }

    public PlayerToken token() {
        return token;
    }

    public double gold() {
        return gold;
    }

    public void gainGold(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Nie mozesz miec ujemnego zlota");
        }
        gold += amount;
    }

    public void loseGold(double amount) {
        if (amount < 0 || gold - amount < 0) {
            throw new IllegalArgumentException("Nie mozesz miec ujemnego zlota");
        }
        gold -= amount;
    }

    public void interactWithToken(Token token) {
        if (token instanceof GoldToken gold) {
            System.out.println("GOLD!");
            gainGold(gold.amount());
        }
    }
}