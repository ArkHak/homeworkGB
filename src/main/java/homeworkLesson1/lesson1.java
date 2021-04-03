package homeworkLesson1;

public class lesson1 {
    public static void main(String[] args) {
        ex2();
        System.out.println(ex3(5.4f, 7.5f, 9.6f, 0.9f));
        System.out.println(ex4(5, 5));
        ex5(7);
        System.out.println(ex6(-25));
        ex7("Bill");
        ex8(2021);
    }

    private static void ex2() {
        System.out.println("Задание №2.");
        byte val1 = -120;
        System.out.println("Переменная типа byte: " + val1);
        short val2 = 12442;
        System.out.println("Переменная типа short: " + val2);
        int val3 = 1000;
        System.out.println("Переменная типа int: " + val3);
        long val4 = 200000L;
        System.out.println("Переменная типа long: " + val4);
        float val5 = 12.23f;
        System.out.println("Переменная типа float: " + val5);
        double val6 = -123.123;
        System.out.println("Переменная типа double: " + val6);
        char val7 = '\u2242';
        System.out.println("Переменная типа char: " + val7);
        boolean val8 = false;
        System.out.println("Переменная типа boolean: " + val8);
        String val9 = "Hello, world!";
        System.out.println("Переменная типа String: " + val9);
    }

    private static float ex3(float a, float b, float c, float d) {
        System.out.println("Задание №3.");
        if (d != 0) {
            return a * (b + (c / d));
        } else {
            System.out.println("Делить на 0 нельзя. Поменяйте значение аргумента d.");
            return 0;
        }
    }

    private static boolean ex4(int num1, int num2) {
        System.out.println("Задание №4.");
        return 10 <= num1 + num2 && num1 + num2 <= 20
    }

    private static void ex5(int num) {
        System.out.println("Задание №5.");
        if (num < 0) {
            System.out.println("Введенное Вами число: " + num + " -- отрицательное");
        } else if (num >= 0) {
            System.out.println("Введенное Вами число: " + num + " -- положительное");
        } else {
            System.out.println("Введены некорректные данные");
        }
    }

    private static boolean ex6(int num) {
        System.out.println("Задание №6.");
        return num >= 0;
    }

    private static void ex7(String name) {
        System.out.println("Задание №7.");
        System.out.println("Привет, " + name + "!");

    }

    private static void ex8(int years) {
        System.out.println("Задание №8*.");
        if (years % 400 == 0) {
            System.out.println("Введенный Вами год: " + years + " -- високосный");
        } else if (years % 4 == 0 && years % 100 != 0) {
            System.out.println("Введенный Вами год: " + years + " -- високосный");
        } else {
            System.out.println("Введенный Вами год: " + years + " -- невисокосный");
        }
    }

}
