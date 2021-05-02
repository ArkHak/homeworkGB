package homeworkLesson7;

public class Day {
    private int numberDay;
    private boolean endEatToday;

    public Day(int numberDay, boolean endEatToday) {
        this.numberDay = numberDay;
        this.endEatToday = endEatToday;
    }

    public int getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(int numberDay) {
        this.numberDay = numberDay;
    }

    public boolean isEndEatToday() {
        return endEatToday;
    }

    public void setEndEatToday(boolean endEatToday) {
        this.endEatToday = endEatToday;
    }
}
