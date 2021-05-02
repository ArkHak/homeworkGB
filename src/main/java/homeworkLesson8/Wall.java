package homeworkLesson8;

public class Wall implements OvercomeObstacle {

    private int heightWall;

    public Wall(int height) {
        this.heightWall = height;
    }

    @Override
    public boolean overcomingObstacle(int measure) {
        return this.heightWall <= measure;
    }

    @Override
    public void overcomingPlus(String whoIs) {
        System.out.println(whoIs + " перепрыгнул препятствие.");
    }

    @Override
    public void overcomingMinus(String whoIs) {
        System.out.println(whoIs + " НЕперепрыгнул препятствие.");
    }

    @Override
    public int getOvercoming() {
        return 0;
    }

}
