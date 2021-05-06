package homeworkLesson8;

public class Robot implements ActionsParticipant {

    private int maxLengthRun;
    private int maxHeightJump;
    private boolean winner = true;

    public Robot(int maxLengthRun, int maxHeightJump) {
        this.maxLengthRun = maxLengthRun;
        this.maxHeightJump = maxHeightJump;
    }

    @Override
    public void run() {
        System.out.println("Робот бежит");
    }

    @Override
    public void jump() {
        System.out.println("Робот прыгнул");
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public int getMaxHeightJump() {
        return maxHeightJump;
    }

    @Override
    public String whoIs() {
        return "Робот";
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
    public void endWinner() {
        if (this.winner) {
            System.out.println(whoIs() + " преодолел полосу препятсвий. Молодец!\n");
        } else {
            System.out.println(whoIs() + " НЕпреодолел полосу препятсвий.\n");
        }
    }

    @Override
    public void ad() {
        System.out.println("***Начинает проходить препятствия - Робот***");
        System.out.printf("""
                Начальные статы:
                Бег: %d,
                Прыжок: %d
                """, this.maxLengthRun, this.maxHeightJump);
    }
}
