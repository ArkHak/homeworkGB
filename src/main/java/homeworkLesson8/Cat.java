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
    public void endWinner() {
        if (this.winner) {
            System.out.println(whoIs() + " преодолел полосу препятсвий. Молодец!\n");
        } else {
            System.out.println(whoIs() + " НЕпреодолел полосу препятсвий.\n");
        }
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
    public boolean winnerIs() {
        return this.winner;
    }

    @Override
    public void ad() {
        System.out.println("***Начинает проходить препятствия - Кот***");
        System.out.printf("""
                Начальные статы:
                Бег: %d,
                Прыжок: %d
                """, this.maxLengthRun, this.maxHeightJump);
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
