package homeworkLesson6;

public class Cat extends Animal{
    private static int countCat = 0;

    public Cat(String name, int maxDistanceRun, int maxDistanceSwim) {
        super(name, maxDistanceRun, maxDistanceSwim);
        setCountCat();
    }

    public Cat(String name) {
        super(name);
        this.maxDistanceRun=200;
        setCountCat();
    }

    @Override
    protected void swim(int distance) {
        System.out.println("Я котик и я не умею плавать. Поэтому не поплыву))");
    }


    public static int getCountCat() {
        return countCat;
    }

    public static void setCountCat() {
        Cat.countCat++;
    }
}
