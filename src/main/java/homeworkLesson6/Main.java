package homeworkLesson6;
//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
// Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//3.У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//4.* Добавить подсчет созданных котов, собак и животных.

public class Main {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Марс");
        Cat cat2 = new Cat("Мурзик");
        Cat cat3 = new Cat("Котярка");
        Dog dog1 = new Dog("Бим");
        Dog dog2 = new Dog("Люси");
        Dog dog3 = new Dog("Макс");
        Dog dog4 = new Dog("Боб");

        toRace(cat1, cat2, cat3, dog1, dog2, dog3, dog4);

        toSwin(cat1, cat2, cat3, dog1, dog2, dog3, dog4);

        infoCreated();
    }

    private static void toRace(Cat cat1, Cat cat2, Cat cat3, Dog dog1, Dog dog2, Dog dog3, Dog dog4) {
        System.out.println("*****Забег котиков и собачек!*****");
        cat1.run(250);
        cat1.run(100);
        cat2.run(5);
        cat2.run(200);
        cat3.run(0);
        cat3.run(201);
        dog1.run(62);
        dog2.run(100);
        dog3.run(500);
        dog4.run(800);
        System.out.println("---------------------------------");
    }

    private static void toSwin(Cat cat1, Cat cat2, Cat cat3, Dog dog1, Dog dog2, Dog dog3, Dog dog4) {
        System.out.println("*****Заплыв кошечек и собачек!*****");
        cat1.swim(5);
        cat2.swim(6);
        cat3.swim(10);
        dog1.swim(10);
        dog2.swim(9);
        dog3.swim(15);
        dog4.swim(2);
        System.out.println("---------------------------------");
    }

    private static void infoCreated() {
        System.out.printf("""
                За время выполнения задания было создано: %d животных.
                Из них:
                %d котиков,
                %d собачек.
                """, Animal.getCountAnimal(), Cat.getCountCat(), Dog.getCountDog());
    }
}
