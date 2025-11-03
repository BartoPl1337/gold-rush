package edu.io.player;

public class Gold {
    private double amount;

    public Gold() {
        this.amount = 0.0;
    }

    public Gold(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Ilosc nie moze byc mniejsza od 0");
        }
        this.amount = amount;
    }

    public double amount() {
        return amount;
    }

    public void gain(double value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        amount += value;
    }

    public void lose(double value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        if (amount - value < 0) {
            throw new IllegalArgumentException();
        }
        amount -= value;
    }
}
