package org.example.game_cows_bulls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        newGame();
    }

    private static void newGame() {
        List<Log> logList = new ArrayList<>();
        System.out.println("Выберите режим игры:\n"
                + "1.Цифры\n"
                + "2.Русский алфавит\n"
                + "3.Английский алфавит");
        Scanner scan1 = new Scanner(System.in);
        int n = scan1.nextInt();
        AbstractGame mode;
        switch (n) {
            case 1:
                mode = new NumberGame();
                System.out.println("Выбран режим 'цифры', мы начинаем");
                startMode(mode, logList);
                break;
            case 2:
                mode = new RuGame();
                System.out.println("Выбран режим 'русские буквы', мы начинаем");
                startMode(mode, logList);
                break;
            case 3:
                mode = new EngGame();
                System.out.println("Выбран режим 'английские буквы', мы начинаем");
                startMode(mode, logList);
                break;
        }
        System.out.println("Сыграть еще раз?\n" + "1.Да\n" + "2.Нет");
        int choice2 = scan1.nextInt();
        switch (choice2){
            case 1:
                newGame();
                break;
            case 2:
                break;
        }
    }

    private static void startMode(AbstractGame mode, List<Log> logList) {
        logList.add(new Log(mode.getGameStatus(), null, null, null));
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите длинну слова: ");
        int wordLength = scan.nextInt();

        System.out.println("Введите колличество попыток: ");
        int countTry = scan.nextInt();

        mode.startGame(wordLength, countTry);
        logList.add(new Log(mode.getGameStatus(), null, null, mode.getTryCount()));

        boolean isFinish = false;
        boolean isWin = false;

        while (!(isFinish || isWin)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ваш вариант ответа: ");
            String n = scanner.nextLine();
            Answer answer = mode.inputValue(n);
            if (answer != null) System.out.println("Ваш результат: " + answer);
            isFinish = mode.getGameStatus() == GameStatus.FINISH;
            isWin = mode.getGameStatus() == GameStatus.WIN;
            logList.add(new Log(mode.getGameStatus(), n, answer, mode.getTryCount()));
        }
        if (isWin) {
            System.out.println("Победа");
        } else {
            System.out.println("Проигрыш");
        }
        System.out.println("Хотите посмотреть историю игры?\n"+"1.Да\n" + "2.Нет");
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                for (Log log1 : logList) {
                    System.out.println("log1 = " + log1);
                }
                break;
            case 2:
                break;
        }
    }
}
