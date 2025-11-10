package edu.io.player;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

public class Vitals {
    public int hydration;
    public Runnable onDeathCallback;

    public Vitals() {
        hydration = 100;
        onDeathCallback = () -> {
        };
    }

    public int hydration() {
        if (hydration < 0) {
            hydration = 0;
        }
        return hydration;
    }

    public void hydrate(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount cannot be negative");
        }
        hydration += amount;
        if (hydration > 100) {
            hydration = 100;
        }
    }

    public void dehydrate(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount cannot be negative");
        }
        hydration -= amount;
        if (hydration == 0) {
            onDeathCallback.run();
        }
    }

    public boolean isAlive() {
        return hydration > 0;
    }

    public void setOnDeathHandler(@NotNull Runnable callback) {
        onDeathCallback = Objects.requireNonNull(callback, "callback cannot be null");
    }
}
