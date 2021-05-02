package homeworkLesson8;

public class Man implements ActionsParticipant {

    private int maxLengthRun;
    private int maxHeightJump;
    private boolean winner = true;

    public Man(int maxLengthRun, int maxHeightJump) {
        this.maxLengthRun = maxLengthRun;
        this.maxHeightJump = maxHeightJump;
    }


    @Override
    public void run() {
        System.out.println("Человек бежит");
    }

    @Override
    public void jump() {
        System.out.println("Человек прыгнул");
    }

    public int getMaxHeightJump() {
        return maxHeightJump;
    }

    @Override
    public String whoIs() {
        return "Человек";
    }

    @Override
    public void failed() {
        this.winner = false;
    }

    public boolean winnerIs() {
        return this.winner;
    }

    public int getMaxLengthRun() {
        return maxLengthRun;
    }

    public void setMaxLengthRun(int lengthRun) {
        this.maxLengthRun = lengthRun;
    }

    @Override
    public void ad() {
        System.out.println("Начинает проходить препятствия - Человек");
    }
}
