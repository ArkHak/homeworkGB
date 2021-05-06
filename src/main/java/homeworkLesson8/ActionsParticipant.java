package homeworkLesson8;

public interface ActionsParticipant {

    void ad();

    void run();

    void jump();

    int getMaxHeightJump();

    String whoIs();

    boolean winnerIs();

    void setWinner(boolean winner);

    int getMaxLengthRun();

    void setMaxLengthRun(int lengthRun);

    void endWinner();
}
