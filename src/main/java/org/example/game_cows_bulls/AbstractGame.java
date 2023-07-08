package org.example.game_cows_bulls;

import java.util.List;
import java.util.Random;

public abstract class AbstractGame implements Game {
    protected int wordLength;
    protected int tryCount;
    protected String word;
    protected GameStatus status = GameStatus.INIT;


    public AbstractGame(int wordLength, int tryCount, String word, GameStatus status) {
        this.wordLength = wordLength;
        this.tryCount = tryCount;
        this.word = word;
        this.status = status;
    }

    public AbstractGame() {
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    @Override
    public void startGame(int wordLength, int countTry) {
        status = GameStatus.START;
        this.wordLength = wordLength;
        this.tryCount = countTry;
        word = generateWord();
        System.out.println("word = " + word);
    }


    @Override
    public Answer inputValue(String value) {
        if (--tryCount == 0) {
            status = GameStatus.FINISH;
        }

        int cows = 0;
        int bulls = 0;

        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == word.charAt(i)) bulls++;
            if (word.contains(String.valueOf(value.charAt(i)))) cows++;
        }

        if (bulls == wordLength) status = GameStatus.WIN;

        return new Answer(cows, bulls);
    }



    private String generateWord() {
        List<String> strList = generateCharList();
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < wordLength; i++) {
            int index = random.nextInt(strList.size());
            str.append(strList.get(index));
            strList.remove(index);
        }
        return str.toString();
    }

    public abstract List<String> generateCharList();
    @Override
    public GameStatus getGameStatus ()
    {
        return status;
    }

}
