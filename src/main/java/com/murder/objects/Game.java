package com.murder.objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Game {

    private GameMap gameMap;
    private int playersCount;
    private boolean isGameStarted = false;

    public Game(GameMap gameMap) {
        this.gameMap = gameMap;
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

    public boolean teleportPlayer(Player player) {
        if(player.teleport(gameMap.getEnterLocation())) {
            updateStatus();
            playersCount++;
            return true;
        }
        return false;
    }

    private void updateStatus() {
        isGameStarted = ( playersCount >= getMaxOfPlayers() );
    }

    public int getMaxOfPlayers() {
        return gameMap.getMaximumOfPlayers();
    }
}