package edu.io.token;

import edu.io.Repairable;
import edu.io.Tool;

public class PickaxeToken extends Token implements Tool, Repairable {
    private final double gainFactor;
    private int durability;
    private final int maxDurability;
    private State state = State.IDLE;

    private enum State {WORKING, BROKEN, IDLE}

    public PickaxeToken() {
        this(1.5, 3);
    }

    public PickaxeToken(double gainFactor) {
        this(gainFactor, 3);
    }

    public PickaxeToken(double gainFactor, int durability) {
        super(Label.PICKAXE_TOKEN_LABEL);
        if (gainFactor <= 0) throw new IllegalArgumentException();
        if (durability <= 0) throw new IllegalArgumentException();
        this.gainFactor = gainFactor;
        this.durability = durability;
        this.maxDurability = durability;
    }

    public double gainFactor() {
        return gainFactor;
    }

    public int durability() {
        return durability;
    }

    public void use() {
        if (durability > 0) durability--;
    }

    @Override
    public boolean isBroken() {
        return durability <= 0;
    }

    @Override
    public PickaxeToken useWith(Token token) {
        if (isBroken()) {
            state = State.BROKEN;
            return this;
        }

        if (token instanceof GoldToken) {
            use();
            state = isBroken() ? State.BROKEN : State.WORKING;
        } else {
            state = State.IDLE;
        }
        return this;
    }

    @Override
    public PickaxeToken ifWorking(Runnable r) {
        if (state == State.WORKING) r.run();
        return this;
    }

    @Override
    public PickaxeToken ifBroken(Runnable r) {
        if (state == State.BROKEN) r.run();
        return this;
    }

    @Override
    public PickaxeToken ifIdle(Runnable r) {
        if (state == State.IDLE) r.run();
        return this;
    }

    public void repair() {
        this.durability = this.maxDurability;
    }
}
