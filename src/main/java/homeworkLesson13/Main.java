package homeworkLesson13;

//Все участники должны стартовать одновременно, несмотря на разное время подготовки.
// В тоннель не может одновременно заехать больше половины участников (условность).
//Первый участник, пересекший финишную черту, объявляется победителем (в момент пересечения
//        этой самой черты). Победитель должен быть только один (ситуация с 0 или 2+ победителями
//        недопустима).


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    private static final int CARS_COUNT = 4;
    private static final int CARS_HALF_COUNT = CARS_COUNT / 2;

    protected static CountDownLatch cdlStart = new CountDownLatch(CARS_COUNT);
    protected static CountDownLatch cdlEnd = new CountDownLatch(CARS_COUNT);
    protected static CyclicBarrier cbStart = new CyclicBarrier(4);
    protected static Semaphore smpTunnel = new Semaphore(CARS_HALF_COUNT);
    protected static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];


        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }


        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        cdlStart.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        cdlEnd.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.exit(0);
    }
}


