package homeworkLesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lesson3 {
    static Scanner in = new Scanner(System.in);
    static String[] words = {"apple", "orange", "lemon", "banana",
            "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
            "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    static final int WORDS_LEN = words.length;
    static final int MAX_LETTERS = 15;

    public static void main(String[] args) {
        ex2();
    }

    private static void ex2() {
        System.out.println("Задание №2.");
        wantToPlay();
    }

    private static void wantToPlay() {
        while (true) {
            System.out.print("""
                    Хочешь сыграть со мной в игру?(Введите соответсвующую цифру)
                    1. Да, хочу сыграть.
                    0. Нет, хочу выйти.
                    """);
            switch (in.next()) {
                case "1" -> toPlay();
                case "0" -> toExit();
                default -> System.out.println("Попробуй еще раз.");
            }
        }
    }

    private static void toPlay() {
        Random random = new Random();
        String answerWord;
        int rightAnswer = 0;
        String hiddenWord = words[random.nextInt(WORDS_LEN - 1)];

        while (true) {
            System.out.print("""
                    Введите загаданное слово:
                    (Для выхода или перезапуска игры введите exit)
                    """);
            answerWord = in.next();
            if (answerWord.equals("exit")) break;
            rightAnswer = checking(answerWord, hiddenWord);
            if (checkRightAnswer(rightAnswer)) break;
        }

    }


    private static int checking(String answerWord, String hiddenWord) {
        if (answerWord.length() < MAX_LETTERS) {
            if (!(answerWord.equals(hiddenWord))) {
                answerWord = modificationWord(answerWord);
                hiddenWord = modificationWord(hiddenWord);
                int checkRightAnswer = 0;
                for (int i = 0; i < MAX_LETTERS; i++) {
                    if (answerWord.charAt(i) == hiddenWord.charAt(i)) {
                        System.out.print(answerWord.charAt(i));
                        checkRightAnswer += 1;
                    } else {
                        System.out.print("#");
                    }
                }
                System.out.println("");
                return checkRightAnswer;
            } else {
                return MAX_LETTERS;
            }
        } else {
            System.out.println("Введено слишком большое слово. Мы загадали слово поменьше.)");
            return 0;
        }
    }

    private static String modificationWord(String word) {
        StringBuilder wordBuilder = new StringBuilder(word);
        for (int i = wordBuilder.length(); i < MAX_LETTERS; i++) {
            wordBuilder.append("#");
        }
        word = wordBuilder.toString();
        return word;
    }

    private static boolean checkRightAnswer(int checkRightAnswer) {
        if (checkRightAnswer == MAX_LETTERS) {
            System.out.println("Молодец, вы угадали загаданное слово!");
            return true;
        } else {
            System.out.println("Увы, поробуй ещё раз.");
            System.out.println();
        }
        return false;
    }

    private static void toExit() {
        while (true) {
            System.out.println("""
                    Вы точно хотите выйти???(Введите соответсвующую цифру)
                    1. Да, хочу выйти.
                    0. Нет, давайте ещё попробуем поиграть.
                    """);
            switch (in.next()) {
                case "1" -> System.exit(0);
                case "0" -> wantToPlay();
                default -> System.out.println("Попробуй еще раз.");
            }
        }
    }
}
