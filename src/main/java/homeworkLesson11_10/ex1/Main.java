package homeworkLesson11_10.ex1;

public class Main {
    public static void main(String[] args) {
        ex1();
    }

    private static void ex1() {
        StorageGen<Integer> intStorage = new StorageGen<>(1,2,3,4,5,6,7,8);
        StorageGen<Integer> intStorage2 = new StorageGen<>(15);
        intStorage.display();
        intStorage2.display();
        intStorage.change(1,8);
    }

}
