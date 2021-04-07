package homeworkLesson2;

import java.util.Arrays;

public class lesson2 {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();

        int[] arrayEx6 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] arrayEx66 = {1, 2, 3, 1, 1, 6};
        int[] arrayEx666 = {1, 2, 3, 1, 6};
        System.out.println(ex6(arrayEx6));
        System.out.println(ex6(arrayEx66));
        System.out.println(ex6(arrayEx666));

        int[] arrayEx7 = {1, 2, 3, 4};
        int[] arrayEx77 = {1, 2, 3, 4};
        ex7(arrayEx7, 6);
        ex7(arrayEx77, -3);

    }

    private static void ex1() {
         /*  1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
          [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
          С помощью цикла и условия заменить 0 на 1, 1 на 0;  */
        System.out.println("Задание №1.");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        outputResult(array, false);

        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
        outputResult(array, true);
    }

    private static void ex2() {
       /* 2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;*/
        System.out.println("Задание №2");
        final int ARRAY_COUNT = 8;
        int FACTOR = 3;
        int[] array = new int[ARRAY_COUNT];
        for (int i = 0; i < ARRAY_COUNT; i++) {
            array[i] = FACTOR * i;
        }
        outputResult(array, true);
    }

    private static void ex3() {
        /*3. Задать массив[ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        пройти по нему циклом, и числа меньшие 6 умножить на 2;*/
        System.out.println("Задание №3.");
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        outputResult(array, false);
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] < 6) ? array[i] * 2 : array[i];
        }
        outputResult(array, true);
    }

    private static void ex4() {
        /* 4. Создать квадратный двумерный целочисленный массив
            (количество строк и столбцов одинаковое),
            и с помощью цикла(-ов) заполнить его диагональные элементы единицами.*/
        System.out.println("Задание №4.");
        final int ARR_COUNT = 13;
        int[][] array = new int[ARR_COUNT][ARR_COUNT];
        for (int i = 0; i < ARR_COUNT; i++) {
            array[i][i] = array[ARR_COUNT - 1 - i][i] = 1;
        }
        nice2DArrayOutput(array);
    }

    private static void ex5() {
       /* 5. Задать одномерный массив и найти в нем минимальный
       и максимальный элементы (без помощи интернета);*/
        System.out.println("Задание №5");
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        outputResult(array, false);
        int min = array[0];
        int max = array[0];
        for (int j : array) {
            if (min > j) min = j;
            if (max < j) max = j;
        }
        System.out.printf("Максимальный элемент массива -- %d%n", max);
        System.out.printf("Минимальный элемент массива -- %d%n", min);
    }

    private static boolean ex6(int[] array) {
        /*6. Написать метод, в который передается не пустой одномерный целочисленный массив,
        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
        массива равны.Примеры:
        checkBalance([2, 2, 2, 1, 2, 2, ||10, 1]) →true, checkBalance([1, 1, 1, ||
        2, 1]) →true, граница показана символами ||,эти символы в массив не входят.*/
        System.out.println("Задание №6.");
        int sumRight = 0;
        int sumLeft = 0;
        for (int i : array) {
            sumRight += i;
        }
        for (int j : array) {
            sumLeft += j;
            sumRight -= j;
            if (sumLeft == sumRight) return true;
        }
        return false;
    }

    private static void ex7(int[] array, int n) {
       /* 7. Написать метод, которому на вход подается одномерный массив и число n (может быть
        положительным, или отрицательным),при этом метод должен сместить все элементы массива
        на n позиций.Элементы смещаются циклично.Для усложнения задачи нельзя пользоваться
        вспомогательными массивами.Примеры: [1, 2, 3 ]при n = 1 (на один вправо) ->[3, 1, 2 ];
        [3, 5, 6, 1]при n = -2 (на два влево) ->[6, 1, 3, 5 ].При каком n в какую сторону сдвиг можете
        выбирать сами.*/
        System.out.println("Задание №7.");
        outputResult(array, false);
        array = shiftArray(array, n);
        outputResult(array, true);
    }


    //для вывода одномерных массивов
    private static void outputResult(int[] array, boolean state) {
        if (!state) System.out.println("Исходный массив:");
        if (state) System.out.println("Полученный массив:");
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    //для красивого вывода двумерного массива.
    private static void nice2DArrayOutput(int[][] array) {
        for (int[] deepDatum : array) {
            for (int num : deepDatum) {
                System.out.printf("%3d", num);
            }
            System.out.println();
        }
        System.out.println();
    }

    //для сдвига.
    private static int[] shiftArray(int[] array, int n) {
        final int ARRAY_LEN = array.length;
        int bufferElement;
        int shift = checkShift(array, n);

        //+ двигаем влево
        if (n > 0 && shift != 0) {
            for (int i = 0; i < shift; i++) {
                bufferElement = array[0];
                for (int j = 0; j < ARRAY_LEN - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[ARRAY_LEN - 1] = bufferElement;
            }
            //- двигаем вправо
        } else if (n < 0 && shift != 0) {
            for (int i = 0; i < shift; i++) {
                bufferElement = array[ARRAY_LEN - 1];
                for (int j = ARRAY_LEN - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = bufferElement;
            }
        }
        return array;
    }

    //для определения сдвига.
    private static int checkShift(int[] array, int n) {
        int ARRAY_LEN = array.length;
        if (Math.abs(n) % ARRAY_LEN == 0) {
            return 0;
        } else {
            if (Math.abs(n) > ARRAY_LEN) {
                return Math.abs(n) % ARRAY_LEN;
            } else if (Math.abs(n) < ARRAY_LEN) {
                return Math.abs(n);
            }
        }
        return 0;
    }
}
