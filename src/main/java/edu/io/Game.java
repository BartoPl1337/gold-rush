package edu.io;

import edu.io.player.Player;
import edu.io.token.PlayerToken;

public class Game {
    private final Board board = new Board();
    private Player player;

    public void join(Player player) {
        this.player = player;
        player.assignToken(new PlayerToken(player, board));
    }

    public void start() {
        board.display();
    }
}
