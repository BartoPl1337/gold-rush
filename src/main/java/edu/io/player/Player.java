package edu.io.player;

import edu.io.Repairable;
import edu.io.token.*;

import java.util.Objects;

public class Player {

    private PlayerToken token;
    public final Gold gold;
    private final Shed shed;
    public Vitals vitals;
    public WaterToken water;

    public Player() {
        this.gold = new Gold();
        this.shed = new Shed();
        this.vitals = new Vitals();
        this.water = new WaterToken();
    }

    public void assignToken(PlayerToken token) {
        if (token == null)
            throw new NullPointerException("Nie moze byc null");
        this.token = token;
    }

    public PlayerToken token() {
        return token;
    }

    public Shed shed() {
        return shed;
    }

    public void interactWithToken(Token token) {
        Objects.requireNonNull(token);
        if(!vitals.isAlive()){
            throw  new IllegalStateException("Vitals are not alive");
        }
        switch (token) {
            case GoldToken goldToken -> {
                if (shed.getTool() instanceof PickaxeToken pickaxe) {
                    pickaxe.useWith(goldToken)
                            .ifWorking(() -> gold.gain(goldToken.amount() * pickaxe.gainFactor()))
                            .ifBroken(() -> gold.gain(goldToken.amount()))
                            .ifIdle(() -> gold.gain(goldToken.amount()));
                } else {
                    gold.gain(goldToken.amount());
                }
                vitals.dehydrate(VitalsValues.DEHYDRATION_GOLD);
            }

            case PickaxeToken pickaxeToken -> {
                shed.add(pickaxeToken);
                vitals.dehydrate(VitalsValues.DEHYDRATION_MOVE);
            }

            case WaterToken waterToken ->{
                vitals.hydrate(waterToken.amount());
            }

            case AnvilToken anvilToken -> {
                if (shed.getTool() instanceof Repairable tool) {
                    tool.repair();
                }
                vitals.dehydrate(VitalsValues.DEHYDRATION_GOLD);
            }

            default -> {
                vitals.dehydrate(VitalsValues.DEHYDRATION_MOVE);
            }
        }
    }

}
