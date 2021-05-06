package homeworkLesson8;

public class Man implements ActionsParticipant {

    private int maxLengthRun;
    private int maxHeightJump;
    private boolean winner = true;

    public Man(int maxLengthRun, int maxHeightJump) {
        this.maxLengthRun = maxLengthRun;
        this.maxHeightJump = maxHeightJump;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
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
        System.out.println("***Начинает проходить препятствия - Человек***");
        System.out.printf("""
                Начальные статы:
                Бег: %d,
                Прыжок: %d
                """, this.maxLengthRun, this.maxHeightJump);
    }
}
