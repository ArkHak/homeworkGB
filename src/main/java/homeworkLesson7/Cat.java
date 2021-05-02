package homeworkLesson7;

public class Cat {
    private final String name;
    private final int maxSatiety;
    private int satiety;
    //private boolean fullSatiety;
    private boolean todayEat;
    private final int starvation = 2;

    public Cat(String name, int maxSatiety) {
        this.name = name;
        this.maxSatiety = maxSatiety;
        this.satiety = 0;
    }

    public void eat(Plate plate, int eat) {
        plate.decreaseFood(eat);
        this.satiety += eat;
        this.todayEat = true;
    }

    public void printInfo() {
        System.out.printf("Котик %s за все дни накушал %d из %d.\n", name, satiety, maxSatiety);
    }

    public boolean checkFullSatiety() {
        return maxSatiety == satiety;
    }

    public int getMaxSatiety() {
        return maxSatiety;
    }

    public int getSatiety() {
        return satiety;
    }

    public boolean isTodayEat() {
        return todayEat;
    }

    public void setTodayEat(boolean todayEat) {
        this.todayEat = todayEat;
    }

    public void hungerDay() {
        this.satiety -= starvation;
    }

    public int getStarvation() {
        return starvation;
    }
}