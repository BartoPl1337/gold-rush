package edu.io;

public record Token(String label) {
    @Override
    public String toString() {
        return label;
    }
}
