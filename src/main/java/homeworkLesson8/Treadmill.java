package homeworkLesson8;

public class Treadmill implements OvercomeObstacle {

    private int lengthTreadmill;

    public Treadmill(int length) {
        this.lengthTreadmill = length;
    }

    @Override
    public boolean overcomingObstacle(int measure) {
        return this.lengthTreadmill <= measure;
    }

    @Override
    public void overcomingPlus(String whoIs) {
        System.out.println(whoIs + " пробежал препятствие.");
    }

    @Override
    public void overcomingMinus(String whoIs) {
        System.out.println(whoIs + " НЕ СМОГ пробежать дистанцию.");
    }


    @Override
    public int getOvercoming() {
        return this.lengthTreadmill;
    }

}
