package homeworkLesson7;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Day eatDay = new Day(1, true);
        //создаем котов и миски(Можно их было вынести в отдельный класс)
        Cat cat1 = new Cat("Мартин", 5);
        Cat cat2 = new Cat("Марс", 7);
        Cat cat3 = new Cat("Рыжуля", 15);
        Cat cat4 = new Cat("Барсик", 10);
        Cat cat5 = new Cat("Борис", 20);
        Cat cat6 = new Cat("Большой Билл", 24);
        Cat[] catsArray = {cat1, cat2, cat3, cat4, cat5, cat6};

        Plate plate1 = new Plate();
        Plate plate2 = new Plate();
        Plate plate3 = new Plate();
        Plate[] platesArray = {plate1, plate2, plate3};

        System.out.println("Котики голодны, а миски пусты. Начнём прикормку)\nДобро пожаловать в лагерь \"Кошкин Дом!\"");

//котики интелегенты, поэтому кушают по-немногу, чтобы всем хватило.

        ex(eatDay, cat1, catsArray, platesArray);

        System.out.println("Все котики накушались до отвала! Теперь счастливы и покидают лагерь \"Кошкин Дом\".\nДо новый встреч! ");

    }

    private static void ex(Day eatDay, Cat cat1, Cat[] catsArray, Plate[] platesArray) throws InterruptedException {
        do {
            System.out.println("День: " + eatDay.getNumberDay());
            //наполнить миски
            fillPlates(eatDay, platesArray);

            System.out.println("Все(3) миски наполнены(по 10).");
            //кормежка
            feeding(catsArray, platesArray);

            //проверка на наедание всех котов.
            checkEatAllCats(eatDay, catsArray);

            //голодание и обнуление дня
            preparingForNewDay(eatDay, cat1, catsArray, platesArray);

        } while (!eatDay.isEndEatToday());
    }

    private static void fillPlates(Day eatDay, Plate[] platesArray) {
        for (int i = 0; i < platesArray.length; i++) {
            platesArray[i].fillPlate();
            eatDay.setEndEatToday(true);
        }
    }

    private static void checkEatAllCats(Day eatDay, Cat[] catsArray) {
        for (Cat cat : catsArray) {
            cat.printInfo();
            eatDay.setEndEatToday(eatDay.isEndEatToday() && cat.checkFullSatiety());
        }
    }

    private static void feeding(Cat[] catsArray, Plate[] platesArray) {
        for (Plate plate : platesArray) {
            for (Cat cat : catsArray) {
                if (!cat.checkFullSatiety() && !cat.isTodayEat()) {
                    if (plate.getFoodCount() >= 5 && (cat.getMaxSatiety() - cat.getSatiety()) >= 5) {
                        cat.eat(plate, 5);
                    } else if (!plate.emptyPlate() && plate.getFoodCount() >= (cat.getMaxSatiety() - cat.getSatiety())) {
                        cat.eat(plate, cat.getMaxSatiety() - cat.getSatiety());
                    } else if (!plate.emptyPlate() && plate.getFoodCount() < (cat.getMaxSatiety() - cat.getSatiety())) {
                        cat.eat(plate, plate.getFoodCount());
                    }
                }
            }
        }
    }

    private static void preparingForNewDay(Day eatDay, Cat cat1, Cat[] catsArray, Plate[] platesArray) throws InterruptedException {
        for (int i = 0; i < platesArray.length; i++) {
            platesArray[i].printInfo(i+1);
        }

        if (!eatDay.isEndEatToday()) {
            for (Cat cat : catsArray) {
                cat.setTodayEat(false);
                cat.hungerDay();
            }
            eatDay.setNumberDay(eatDay.getNumberDay() + 1);
            Thread.sleep(3000);
            System.out.println("------------------------------------------------------");
            System.out.printf("Котики проголодались и их статы(наедание) упали на %d\n\n", cat1.getStarvation());
            Thread.sleep(3000);
        }
    }


}
