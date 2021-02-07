package com.murder.objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Game {

    private int maxPlayers;
    private Location location;
    private int playersCount;
    private boolean isGameStarted = false;

    public Game(Location location, int maxPlayers) {
        this.location = location;
        this.maxPlayers = maxPlayers;
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
        if(player.teleport(location)) {
            updateStatus();
            playersCount++;
            return true;
        }
        return false;
    }

    private void updateStatus() {
        isGameStarted = ( playersCount >= maxPlayers );
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }
}