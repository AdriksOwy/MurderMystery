package com.murder.objects;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.Collection;

public class GameMap {
    private final Location enterLocation;
    private final int maximumOfPlayers = 12;

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

    public GameMap(Location enterLocation) {
        this.enterLocation = enterLocation;
    }
}
