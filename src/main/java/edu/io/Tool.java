package edu.io;

import edu.io.token.Token;

public interface Tool {
    Tool useWith(Token token);

    Tool ifWorking(Runnable r);

    Tool ifBroken(Runnable r);

    Tool ifIdle(Runnable r);

    boolean isBroken();
}
