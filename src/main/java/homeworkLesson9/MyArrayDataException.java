package homeworkLesson9;

import java.io.IOException;

public class MyArrayDataException extends IOException {
    int i, j;

    public MyArrayDataException(int i, int j) {
        super("В ячейке [" + i + "][" + j + "] лежит не число. Вы плохой(но хороший тестер)!");
        this.i = i;
        this.j = j;
    }
}
