package homeworkLesson4;

import java.util.Random;
import java.util.Scanner;

public class lesson4 {

    static int SIZE;
    static char[][] MAP;

    private static final String EMPTY = " ";
    private static final String HEADER_FIRST_SIMBOL = "♥";

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = '0';
    static final int crit1 = 3;
    static final int crit2 = 4;
    static final int crit3 = 5;

    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();
    static int turnCount = 0;

    static String identification = "Победа!";

    public static void main(String[] args) {
        SIZE = gameSize();
        MAP = new char[SIZE][SIZE];
        turnGame();
    }

    private static int gameSize() {
        int size;
        System.out.print("""
                Введите размерность игрового поля n*n.
                (При разных размерностях - разные условия выиграша:
                при n = от 3 до 6, победа достигается при 3-ех подряд;
                при n = от 7 до 10, победа достигается при 4-ех подряд;
                при n = больше 11, победа достигается при 5-ти подряд;)
                n =  """);
        do {
            if (in.hasNextInt()) {
                size = in.nextInt();
                return size;
            } else {
                in.nextLine();
                System.out.println("Введите целочисленное число.\n");
            }
        } while (true);
    }

    private static void turnGame() {
        MAP = initMap();
        printMap();
        playGame();
    }

    private static char[][] initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
        return MAP;
    }

    private static void printMap() {
        printHeaderMap();
        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SIMBOL + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i); //для столбцов
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);//для строчек
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + EMPTY);
            }
            System.out.println();
        }
    }

    private static void playGame() {
        do {
            stepGameHuman();
            printMap();
            toDraw();

            stepGameAi();
            printMap();
            toDraw();
        } while (true);
    }

    private static void stepGameHuman() {
        if (humanTurn()) {
            endGame();
        }
    }

    private static void stepGameAi() {
        if (aiTurn()) {
            endGame();
        }
    }

    private static void toDraw() {
        if (isMapFull()) {
            System.out.println("Ничья!");
            endGame();
        }
    }

    private static boolean humanTurn() {
        identification = "Человек!";
        int rowNumber;
        int colNumber;
        boolean isInputValid;

        System.out.println("\nХод человека! Введите номера строки и столбца");

        do {
            rowNumber = -1;
            colNumber = -1;
            isInputValid = true;

            System.out.println("Строка: ");
            if (in.hasNextInt()) {
                rowNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
                continue;
            }

            System.out.println("Столбец: ");
            if (in.hasNextInt()) {
                colNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
            }
        } while (!(isInputValid && isHumanTurnValid(rowNumber, colNumber)));

        MAP[rowNumber][colNumber] = DOT_HUMAN;
        turnCount++;
        return checkWinHW(rowNumber, colNumber, identification);
    }

    private static void processingIncorrectInput() {
        System.out.println("Ошибка ввода! Введите число в диапазоне игрового поля");
        in.next();
    }

    private static boolean isHumanTurnValid(int rowNumber, int colNumber) {
        if (!isNumberValid(rowNumber, colNumber)) {
            System.out.println("\nПроверьте значение строки и столбца");
            return false;
        }
        if (!isCellFree(rowNumber, colNumber)) {
            System.out.println("\nВы выбрали занятую ячейку");
            return false;
        }
        return true;
    }

    private static boolean isNumberValid(int rowNumber, int colNumber) {
        return rowNumber < SIZE && rowNumber >= 0 && colNumber < SIZE && colNumber >= 0;
    }

    private static boolean isCellFree(int rowNumber, int colNumber) {
        return MAP[rowNumber][colNumber] == DOT_EMPTY;
    }

//**Домашнее задание!(УНИВЕРСАЛЬНЫЙ Поиск победы!)*********************************************************************
    private static boolean checkWinHW(int rowNumber, int colNumber, String identification) {
        if (checkWinner(rowNumber, colNumber, identification)) {
            printMap();
            System.out.println("Победу одержал - " + identification);
            return true;
        }
        return false;
    }

    private static boolean checkWinner(int rowNumber, int colNumber, String identification) {
        char DOT_METKA = '.';
        if (identification.equals("Человек!")) {
            DOT_METKA = DOT_HUMAN;
        } else if (identification.equals("Компустер")) {
            DOT_METKA = DOT_AI;
        }
        if (checkHorizontal(rowNumber, DOT_METKA)) {
            return true;
        }
        if (checkVertical(colNumber, DOT_METKA)) {
            return true;
        }
        if (checkMainDiagonal(DOT_METKA)) {
            return true;
        }
        if (checkCollateralDiagonal(DOT_METKA)) {
            return true;
        }
        return false;
    }

    private static boolean checkHorizontal(int rowNumber, char DOT_METKA) {
        if (SIZE >= 3 && SIZE <= 6) {
            return checkHorizontalCrit(rowNumber, DOT_METKA, crit1);
        }

        if (SIZE >= 7 && SIZE <= 10) {
            return checkHorizontalCrit(rowNumber, DOT_METKA, crit2);
        }

        if (SIZE >= 11) {
            return checkHorizontalCrit(rowNumber, DOT_METKA, crit3);
        }
        return false;
    }

    private static boolean checkHorizontalCrit(int rowNumber, char DOT_METKA, int crit) {
        int win = 0;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[rowNumber][i] == DOT_METKA) {
                win++;
                if (win == crit) {
                    return true;
                }
            } else if (MAP[rowNumber][i] != DOT_METKA) {
                win = 0;
            }
        }
        return false;
    }

    private static boolean checkVertical(int colNumber, char DOT_METKA) {
        if (SIZE >= 3 && SIZE <= 6) {
            return checkVerticalCrit(colNumber, DOT_METKA, crit1);
        }

        if (SIZE >= 7 && SIZE <= 10) {
            return checkVerticalCrit(colNumber, DOT_METKA, crit2);
        }

        if (SIZE >= 11) {
            return checkVerticalCrit(colNumber, DOT_METKA, crit3);
        }
        return false;
    }

    private static boolean checkVerticalCrit(int colNumber, char DOT_METKA, int crit) {
        int win = 0;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][colNumber] == DOT_METKA) {
                win++;
                if (win == crit) {
                    return true;
                }
            } else if (MAP[i][colNumber] != DOT_METKA) {
                win = 0;
            }
        }
        return false;
    }

    private static boolean checkMainDiagonal(char DOT_METKA) {
        if (SIZE >= 3 && SIZE <= 6) {
            if (checkMainDiagonalCouple(DOT_METKA, crit1)) return true;
        }

        if (SIZE >= 7 && SIZE <= 10) {
            if (checkMainDiagonalCouple(DOT_METKA, crit2)) return true;
        }

        if (SIZE >= 11) {
            if (checkMainDiagonalCouple(DOT_METKA, crit3)) return true;
        }
        return false;
    }

    private static boolean checkMainDiagonalCouple(char DOT_METKA, int crit) {
        //от главной диагонали в правый верхний угол
        if (checkMainDiagonalRightUp(DOT_METKA, crit)) return true;
        //от главной диагонали в левый нижний
        if (checkMainDiagonalLeftDown(DOT_METKA, crit)) return true;
        return false;
    }

    private static boolean checkMainDiagonalRightUp(char DOT_METKA, int crit) {
        int win;
        int sizeRow = SIZE;
        for (int i = 0; i < SIZE; i++) {
            win = 0;
            for (int j = 0; j < sizeRow; j++) {
                if (MAP[j][j + i] == DOT_METKA) {
                    win++;
                    if (win == crit) {
                        return true;
                    }
                } else if (MAP[j][j + i] != DOT_METKA) {
                    win = 0;
                }
            }
            sizeRow--;
        }
        return false;
    }

    private static boolean checkMainDiagonalLeftDown(char DOT_METKA, int crit) {
        int sizeCol = SIZE;
        int win;
        for (int i = 0; i < SIZE; i++) {
            win = 0;
            for (int j = 0; j < sizeCol; j++) {
                if (MAP[j + i][j] == DOT_METKA) {
                    win++;
                    if (win == crit) {
                        return true;
                    }
                } else if (MAP[j + i][j] != DOT_METKA) {
                    win = 0;
                }
            }
            sizeCol--;
        }
        return false;
    }

    private static boolean checkCollateralDiagonal(char DOT_METKA) {
        if (SIZE >= 3 && SIZE <= 6) {
            if (checkCollateralDiagonalCouple(DOT_METKA, crit1)) return true;
        }

        if (SIZE >= 7 && SIZE <= 10) {
            if (checkCollateralDiagonalCouple(DOT_METKA, crit2)) return true;
        }

        if (SIZE >= 11) {
            if (checkCollateralDiagonalCouple(DOT_METKA, crit3)) return true;
        }
        return false;
    }

    private static boolean checkCollateralDiagonalCouple(char DOT_METKA, int crit) {
        //от побочной диагонали в левый верхний угол
        if (checkCollateralDiagonalLeftUp(DOT_METKA, crit)) return true;
        //от побочной диагонали в правый нижний
        if (checkCollateralDiagonalRightDown(DOT_METKA, crit)) return true;
        return false;
    }

    private static boolean checkCollateralDiagonalLeftUp(char DOT_METKA, int crit) {
        int sizeRow = SIZE;
        int win;
        for (int i = SIZE - 1; i >= 0; i--) {
            win = 0;
            for (int j = 0; j < sizeRow; j++) {
                if (MAP[i - j][j] == DOT_METKA) {
                    win++;
                    if (win == crit) {
                        return true;
                    }
                } else if (MAP[i - j][j] != DOT_METKA) {
                    win = 0;
                }
            }
            sizeRow--;
        }
        return false;
    }

    private static boolean checkCollateralDiagonalRightDown(char DOT_METKA, int crit) {
        int sizeCol = 0;
        int win;
        for (int i = 0; i < SIZE; i++) {
            win = 0;
            for (int j = SIZE - 1; j >= sizeCol; j--) {
                if (MAP[j][i + (SIZE - 1) - j] == DOT_METKA) {
                    win++;
                    if (win == crit) {
                        return true;
                    }
                } else if (MAP[j][i + (SIZE - 1) - j] != DOT_METKA) {
                    win = 0;
                }
            }
            sizeCol++;
        }
        return false;
    }

    private static boolean isMapFull() {
        return turnCount == SIZE * SIZE;
    }

    private static boolean aiTurn() {
        identification = "Компустер";
        int rowNumber;
        int colNumber;

        System.out.println("\nХод компьютера");
        do {
            rowNumber = random.nextInt(SIZE);
            colNumber = random.nextInt(SIZE);
        } while (!isCellFree(rowNumber, colNumber));
        MAP[rowNumber][colNumber] = DOT_AI;
        turnCount++;
        return checkWinHW(rowNumber, colNumber, identification);
    }

    private static void endGame() {
        System.exit(0);
    }
}
