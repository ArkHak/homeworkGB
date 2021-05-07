package homeworkLesson11_10.bigEx3;

public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBoxTwo = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        ex2(apple1, apple2, apple3, apple4, orange1, orange2, orange3, appleBox, orangeBox);

        ex4(appleBox, orangeBox);

        ex5(appleBox, orangeBox);

        ex6(appleBox, appleBoxTwo);
    }

    private static void ex2(Apple apple1, Apple apple2, Apple apple3, Apple apple4, Orange orange1, Orange orange2, Orange orange3, Box<Apple> appleBox, Box<Orange> orangeBox) {
        appleBox.add(apple1);
        appleBox.add(apple2);
        appleBox.add(apple3);
        appleBox.add(apple4);
//        appleBox.add(orange1);
        orangeBox.add(orange1);
        orangeBox.add(orange2);
        orangeBox.add(orange3);
//        orangeBox.add(apple);
    }

    private static void ex4(Box<Apple> appleBox, Box<Orange> orangeBox) {
        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
    }

    private static void ex5(Box<Apple> appleBox, Box<Orange> orangeBox) {
        System.out.println("Коробки равны по весу: " + appleBox.compare(orangeBox));
    }

    private static void ex6(Box<Apple> appleBox, Box<Apple> appleBoxTwo) {
        appleBox.display();
        appleBoxTwo.display();
        appleBoxTwo.shift(appleBox);
        appleBox.display();
        appleBoxTwo.display();
    }
}
