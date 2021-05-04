package homeworkLesson9;

import java.util.Scanner;

public class Main {

//1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
//    подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и
//    просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
//    ячейке лежит символ или текст вместо числа), должно быть брошено исключение
//    MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//3. В методе main() вызвать полученный метод, обработать возможные исключения
//    MyArraySizeException и MyArrayDataException и вывести результат расчета.

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[][] array = createdArray(in);

        try {
            ex1(array, in);
            ex2(array);
        } catch (MyArraySizeException e) {
            System.err.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

    }

    private static void ex1(String[][] arr, Scanner in) {
        int rows = arr.length;
        int columns = arr[0].length;
        if (rows != 4 || columns != 4) throw new MyArraySizeException();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                printArray(arr);
                System.out.printf("Введите значение поля [%d][%d]: ", i, j);
                arr[i][j] = in.next();
            }
        }
        System.out.println("Созданный массив: ");
        printArray(arr);
        in.close();
    }

    private static void printArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void ex2(String[][] arr) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Сумма членов всех массива: " + sum);
    }

    private static String[][] createdArray(Scanner in) {
        int row;
        int column;
        System.out.println("Давайте создадим 2D-массив 4x4!");
        System.out.println("Введите размер строки: ");
        row = in.nextInt();
        System.out.println("Введите размер колонки:");
        column = in.nextInt();
        return new String[row][column];
    }
}
