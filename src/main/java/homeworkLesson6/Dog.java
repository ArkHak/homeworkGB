package homeworkLesson6;

public class Dog extends Animal {
    private static int countDog = 0;

    public Dog(String name, int maxDistanceRun, int maxDistanceSwim) {
        super(name, maxDistanceRun, maxDistanceSwim);
        setCountDog();
    }

    public Dog(String name) {
        super(name);
        this.maxDistanceRun = 500;
        this.maxDistanceSwim = 10;
        setCountDog();
    }

    @Override
    protected void swim(int distance) {
        if (maxDistanceSwim < distance) {
            System.out.printf("%s не проплывёт, потому что устанет.(Дистанция: %d м.)\n", name, distance);
        } else {
            System.out.printf("%s проплыл %d м.\n", name, distance);
        }
    }

    public static int getCountDog() {
        return countDog;
    }

    public static void setCountDog() {
        Dog.countDog++;
    }
}
