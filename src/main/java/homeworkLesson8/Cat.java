package homeworkLesson8;

public class Cat implements ActionsParticipant {

    private int maxLengthRun;
    private int maxHeightJump;
    private boolean winner = true;

    public Cat(int maxLengthRun, int maxHeightJump) {
        this.maxLengthRun = maxLengthRun;
        this.maxHeightJump = maxHeightJump;
    }

    @Override
    public void run() {
        System.out.println("Кот бежит");
    }

    public int getMaxLengthRun() {
        return maxLengthRun;
    }

    public void setMaxLengthRun(int lengthRun) {
        this.maxLengthRun = lengthRun;
    }

    @Override
    public void jump() {
        System.out.println("Кот прыгнул");
    }

    public int getMaxHeightJump() {
        return maxHeightJump;
    }

    @Override
    public String whoIs() {
        return "Кот";
    }

    @Override
    public void failed() {
        this.winner = false;
    }

    @Override
    public boolean winnerIs() {
        return this.winner;
    }

    @Override
    public void ad() {
        System.out.println("Начинает проходить препятствия - Кот");
    }
}
