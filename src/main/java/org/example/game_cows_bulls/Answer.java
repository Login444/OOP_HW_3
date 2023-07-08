package org.example.game_cows_bulls;

public class Answer {
    private int cows;
    private int bulls;

    public Answer() {
    }

    @Override
    public String toString() {
        return cows + " коровы, " +
                bulls + " быки";
    }

    public int getCows() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }

    public int getBulls() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }


    public Answer(int cows, int bulls) {
        this.cows = cows;
        this.bulls = bulls;
    }
}
