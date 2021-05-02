package homeworkLesson8;

public class Main {
//    1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
//    классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
//    консоль).
//    2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
//    должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
//    печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
//    3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
//    этот набор препятствий.
//    4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения
//    на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
//    препятствий не идет.

    public static void main(String[] args) {

        ActionsParticipant cat = new Cat(200, 3);
        ActionsParticipant man = new Man(1000, 2);
        ActionsParticipant robot = new Robot(700, 1);

        ActionsParticipant[] participantsArray = {cat, man, robot};

        OvercomeObstacle let1 = new Treadmill(150);
        OvercomeObstacle let2 = new Wall(1);
        OvercomeObstacle let3 = new Treadmill(500);
        OvercomeObstacle let4 = new Wall(2);
        OvercomeObstacle let5 = new Treadmill(150);

        OvercomeObstacle[] letsArray = {let1, let2, let3, let4, let5};

        ex1(participantsArray);

        homeworkFull(participantsArray, letsArray);

    }

    private static void ex1(ActionsParticipant[] participantsArray) {
        System.out.println("Демонстрация, что каждый умеет бешать и прыгать:");
        for (ActionsParticipant participant : participantsArray) {
            participant.run();
            participant.jump();
        }
        System.out.println("------------------------------");
    }

    private static void overcomingFailed(ActionsParticipant participant, OvercomeObstacle let) {
        let.overcomingMinus(participant.whoIs());
        System.out.println(participant.whoIs() + " не смог пройти полосу препятствий.");
        participant.failed();
    }

    private static void endWinner(ActionsParticipant participant) {
        if (participant.winnerIs()) {
            System.out.println(participant.whoIs() + " преодолел полосу препятсвий. Молодец!");
        }
        System.out.println("");
    }

    private static void homeworkFull(ActionsParticipant[] participantsArray, OvercomeObstacle[] letsArray) {
        String typeObstacle;
        for (ActionsParticipant participant : participantsArray) {
            participant.ad();
            for (OvercomeObstacle let : letsArray) {
                typeObstacle = (let.toString().replace("homeworkLesson8.", "").split("@")[0]);
                if (participant.winnerIs()) {
                    switch (typeObstacle) {
                        case "Treadmill" -> {
                            if (let.overcomingObstacle(participant.getMaxLengthRun())) {
                                let.overcomingPlus(participant.whoIs());
                                participant.setMaxLengthRun(participant.getMaxLengthRun() - let.getOvercoming());
                            } else {
                                overcomingFailed(participant, let);
                            }
                        }
                        case "Wall" -> {
                            if (let.overcomingObstacle(participant.getMaxHeightJump())) {
                                let.overcomingPlus(participant.whoIs());
                            } else {
                                overcomingFailed(participant, let);
                            }
                        }
                    }
                }
            }
            endWinner(participant);
        }
    }
}
