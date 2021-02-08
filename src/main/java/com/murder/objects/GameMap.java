package com.murder.objects;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.Collection;

public class GameMap {
    private Location enterLocation;
    private int maximumOfPlayers;

    public static GameMap getRandom() {
        /*TODO
         * draw all GameMaps's data and
         * create GameMaps and
         * get random one and
         * return
         */
        return null;
    }

    public World getWorld() {
        return enterLocation.getWorld();
    }
    public Location getEnterLocation() {
        return enterLocation;
    }
    public int getMaximumOfPlayers() {
        return maximumOfPlayers;
    }

    public GameMap(Location enterLocation, int maximumOfPlayers) {
        this.enterLocation = enterLocation;
        this.maximumOfPlayers = maximumOfPlayers;
    }
}
