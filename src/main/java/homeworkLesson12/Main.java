package homeworkLesson12;

import java.util.Arrays;

public class Main {
    //    1) Создают одномерный длинный массив,
//    2) Заполняют этот массив единицами;
//    3) Засекают время выполнения
//    4) Проходят по всему массиву и для каждой ячейки считают новое значение
//    5) Проверяется время окончания метода System.currentTimeMillis();
//    6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
//    *для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.

    static final int SIZE = 10000000;
    ;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        methodSingle();
        methodDual();
    }

    private static void methodSingle() {
        float[] arrSingle = new float[SIZE];
        stepTwo(arrSingle);
        long timerSingle = System.currentTimeMillis();
        stepFour(arrSingle);
        stepsEnd(timerSingle, "methodSingle");
//        System.out.println(Arrays.toString(arrSingle));
    }

    private static void methodDual() throws InterruptedException {
        float[] arrDual = new float[SIZE];
        float[] arrDualOneCharter = new float[HALF];
        float[] arrDualTwoCharter = new float[HALF];

        stepTwo(arrDual);
        long timerDual = System.currentTimeMillis();

        System.arraycopy(arrDual, 0, arrDualOneCharter, 0, HALF);
        System.arraycopy(arrDual, HALF, arrDualTwoCharter, 0, HALF);

        WorkDualThread(arrDualOneCharter, arrDualTwoCharter);

        System.arraycopy(arrDualOneCharter, 0, arrDual, 0, HALF);
        System.arraycopy(arrDualTwoCharter, 0, arrDual, HALF, HALF);
        stepsEnd(timerDual, "methodDual");

//        System.out.println(Arrays.toString(arrDualOneCharter));
//        System.out.println(Arrays.toString(arrDualTwoCharter));
//        System.out.println(Arrays.toString(arrDual));
    }

    private static void WorkDualThread(float[] arrDualOneCharter, float[] arrDualTwoCharter) throws InterruptedException {
        var charterOne = new Thread(() -> {
            stepFour(arrDualOneCharter);
        }, "arrDualOneCharter");

        var charterTwo = new Thread(() -> {
            stepFour(arrDualTwoCharter, HALF);
        }, "arrDualTwoCharter");
        charterOne.start();
        charterTwo.start();

        charterOne.join();
        charterTwo.join();

    }


    private static void stepTwo(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

    private static void stepFour(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    private static void stepFour(float[] arr, int iTwo) {
        for (int i = 0; i < arr.length; i++, iTwo++) {
            iTwo = i + HALF;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + iTwo / 5) * Math.cos(0.2f + iTwo / 5) * Math.cos(0.4f + iTwo / 2));
        }
    }

    private static void stepsEnd(long timerSingle, String s) {
        System.out.println("Время окончания работы " + s + ": " + System.currentTimeMillis());
        System.out.println("Время работы " + s + ": " + (System.currentTimeMillis() - timerSingle));
    }
}
