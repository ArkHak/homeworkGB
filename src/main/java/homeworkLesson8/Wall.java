package homeworkLesson8;

public class Wall implements OvercomeObstacle {

    private int heightWall;

    public Wall(int height) {
        this.heightWall = height;
    }

    @Override
    public boolean passing(ActionsParticipant participant) {
        if (this.heightWall <= participant.getMaxHeightJump()) {
            System.out.printf("%s перепрыгнул стену в %d м.\n", participant.whoIs(), this.heightWall);
            return true;
        } else {
            System.out.printf("%s НЕперепрыгнул стену в %d м.\n", participant.whoIs(), this.heightWall);
            return false;
        }
    }
}
