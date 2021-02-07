package com.murder.objects;

import org.bukkit.World;

public class Game {

    private World world;
    private int playersCount;
    private boolean isGameStarted = false;

    public Game(World world) {
        this.world = world;
    }

    public int getPlayersCount() {
        return playersCount;
    }

    public boolean isGameStarted() {
        return isGameStarted;
    }

    public void setPlayersCount(int playersCount) {
        this.playersCount = playersCount;
    }

    public void setGameStatus(boolean isGameStarted) {
        this.isGameStarted = isGameStarted;
    }
}