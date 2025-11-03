package edu.io.player;

import edu.io.Tool;
import edu.io.token.Token;

public class NoTool implements Tool {
    @Override
    public Tool useWith(Token withToken) {
        return this;
    }

    @Override
    public Tool ifWorking(Runnable r) {
        return this;
    }

    @Override
    public Tool ifBroken(Runnable r) {
        return this;
    }

    @Override
    public Tool ifIdle(Runnable r) {
        return this;
    }

    @Override
    public boolean isBroken() {
        return false;
    }
}
