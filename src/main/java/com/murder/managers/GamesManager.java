package com.murder.managers;

import com.murder.objects.Game;
import org.bukkit.World;

import java.util.List;

public class GamesManager {

    private List<Game> gameList;

    public void createGame(World world) {
        Game game = new Game(world);
        gameList.add(game);
    }
    public List<Game> getGames() {
        return gameList;
    }
}