package homeworkLesson6;

public abstract class Animal {
    private static int countAnimal = 0;

    protected String name;
    protected int maxDistanceRun;
    protected int maxDistanceSwim;

    public Animal(String name, int maxDistanceRun, int maxDistanceSwim) {
        this.name = name;
        this.maxDistanceRun = maxDistanceRun;
        this.maxDistanceSwim = maxDistanceSwim;
        setCountAnimal();
    }

    public Animal(String name) {
        this(name, 0, 0);
    }

    protected void run(int distance) {
        if (maxDistanceRun < distance) {
            System.out.printf("%s не побежит, потому что устанет.(Дистанция: %d м.)\n", name, distance);
        } else {
            System.out.printf("%s пробежал %d м.\n", name, distance);
        }
    }
//в целях разнообразия сделал данный метод абстрактным. А так, это скорее неправильно, чем правильно.
    protected abstract void swim(int distance);

    public static int getCountAnimal() {
        return countAnimal;
    }

    public static void setCountAnimal() {
        Animal.countAnimal++;
    }
}
