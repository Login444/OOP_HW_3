package org.example.game_cows_bulls;

public class Log {
    GameStatus status;
    String valueAnswer;
    Answer answerResult;
    Integer tryCount;

    public Log(GameStatus status, String valueAnswer, Answer answer, Integer tryCount) {
        this.status = status;
        this.valueAnswer = valueAnswer;
        this.answerResult = answer;
        this.tryCount = tryCount;
    }


    @Override
    public String toString() {
        return "Log{" +
                "статус игры: " + status +
                ", введеный ответ: " + valueAnswer + '\'' +
                ", результат ответа: " + answerResult +
                ", осталось попыток: " + tryCount +
                '}';
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public String getValueAnswer() {
        return valueAnswer;
    }

    public void setValueAnswer(String valueAnswer) {
        this.valueAnswer = valueAnswer;
    }

    public Answer getAnswerResult() {
        return answerResult;
    }

    public void setAnswerResult(Answer answerResult) {
        this.answerResult = answerResult;
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public void setTryCount(Integer tryCount) {
        this.tryCount = tryCount;
    }
}
