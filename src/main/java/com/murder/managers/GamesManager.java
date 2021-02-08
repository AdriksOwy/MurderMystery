package com.murder.managers;

import com.murder.objects.Game;
import com.murder.objects.GameMap;
import org.bukkit.entity.Player;

import java.util.List;

public class GamesManager {

    private List<Game> gameList;

    public synchronized boolean addPlayerToGameOrCreateGame(Player player) {
        int lastIndex = gameList.size() - 1;
        Game game = gameList.get(lastIndex);
        if (game.getPlayersCount() < game.getMaxOfPlayers()) {
            return game.teleportPlayer(player);
        } else {
            Game newGame = createGameAndAddToList();
            return newGame.teleportPlayer(player);
        }
    }

    private Game createGameAndAddToList() {
        GameMap gameMap = GameMap.getRandom();
        Game game = new Game(gameMap);
        gameList.add(game);
        return game;
    }

    public List<Game> getGames() {
        return gameList;
    }
}