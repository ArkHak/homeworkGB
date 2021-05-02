package homeworkLesson7;

public class Plate {
    private int foodCount;
    private int maxFoodCount;

    public Plate() {
        this.foodCount = 0;
        this.maxFoodCount = 10;
    }

    void printInfo(int number) {
        System.out.printf("Еды в миске №%d: %d\n", number, foodCount);
    }

    public void decreaseFood(int foodCount) {
        this.foodCount -= foodCount;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void fillPlate() {
        foodCount = maxFoodCount;
    }

    public boolean emptyPlate() {
        return foodCount == 0;
    }
}