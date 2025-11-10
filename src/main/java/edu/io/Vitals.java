package edu.io;

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
        return hydration;
    }

    public void hydrate(int amount) {
        hydration += amount;
    }

    public void dehydrate(int amount) {
        hydration -= amount;
        if (hydration < 0) {
            onDeathCallback.run();
        }
    }

    public boolean isAlive() {
        return hydration > 0;
    }

    public void setOnDeathHandler(@NotNull Runnable callback) {
//        Objects.requireNonNull(callback, "callback cannot be null");
        onDeathCallback = Objects.requireNonNull(callback, "callback cannot be null");
//        onDeathCallback = callback;
    }
}
