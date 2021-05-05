package homeworkLesson9;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {

    public MyArraySizeException() {
        super("Размер созданного Вами массива не 4x4, мы так не договаривались....(");
    }
}
