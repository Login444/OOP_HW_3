package org.example.game_cows_bulls;

public interface Game {
    void startGame(int wordLength, int countTry);

    Answer inputValue(String value);

    GameStatus getGameStatus();

}
