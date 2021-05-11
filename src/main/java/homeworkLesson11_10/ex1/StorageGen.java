package homeworkLesson11_10.ex1;

public class StorageGen<E> {
    private E[] data;
    public static final int DEF_SIZE = 15;
    private int currentSize;

    public StorageGen(int size) {
        this.data = (E[]) new Object[size];
        currentSize = 0;
    }

    public StorageGen(E... data) {
        this.data = data;
    }

    public StorageGen() {
        this(DEF_SIZE);
    }

    public void display() {
        for (E datum : data) {
            System.out.print(datum + " ");
        }
        System.out.println();
    }

    public void change(int indexOne, int indexTwo) {
        E temp = data[indexOne - 1];
        data[indexOne - 1] = data[indexTwo - 1];
        data[indexTwo - 1] = temp;
        System.out.println("Замена проведена: ");
        this.display();
    }


}
