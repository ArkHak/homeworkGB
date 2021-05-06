package homeworkLesson8;

public class Treadmill implements OvercomeObstacle {

    private int lengthTreadmill;

    public Treadmill(int length) {
        this.lengthTreadmill = length;
    }

    @Override
    public boolean passing(ActionsParticipant participant) {
        int differentDistance = participant.getMaxLengthRun() - this.lengthTreadmill;
        if (differentDistance >= 0) {
            participant.setMaxLengthRun(differentDistance);
            System.out.printf("%s смог пробежать дистанцию в %d м.\n", participant.whoIs(), this.lengthTreadmill);
            return true;
        } else {
            System.out.printf("%s НЕсмог пробежать дистанцию в %d м.\n", participant.whoIs(), this.lengthTreadmill);
            return false;
        }
    }
}
