package homeworkLesson11_10.bigEx3;

public class Box<E extends Fruit> {

    private E[] fruit;
    private static final int DEFAULT_SIZE = 10;
    private int currentSize;

    public Box(int size) {
        this.fruit = (E[]) new Fruit[size];
        currentSize = 0;
    }

    public Box() {
        this(DEFAULT_SIZE);
    }

    public void add(E value) {
        add(value, currentSize);
    }


    public void add(E value, int index) {
        fruit[index] = value;
        currentSize++;
    }

    public void display() {
        for (E datum : fruit) {
            System.out.print(datum + " ");
        }
        System.out.println();
    }

    public boolean compare (Box box){
        return this.getWeight() == box.getWeight();
    }

    public float getWeight() {
        if (currentSize == 0) return 0;
        float weight = 0;
        for (int i = 0; i < currentSize; i++) {
            weight += fruit[i].getWeight();
        }
        return weight;
    }

    public void shift(Box<E> box){
        for (int i = 0; i < box.currentSize; i++) {
            this.add(box.fruit[i]);
            box.fruit[i] = null;
        }
    }

    public int getCurrentSize() {
        return currentSize;
    }
}
