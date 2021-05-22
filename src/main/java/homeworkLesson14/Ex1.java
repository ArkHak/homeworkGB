package homeworkLesson14;

import java.util.Arrays;

public class Ex1 {
    private static final Integer ex1 = 4;

    public int[] endForFour(int[] arrInt) {
        if (Arrays.stream(arrInt).anyMatch(ex1::equals)) {
            int i = findIndexFour(arrInt);
            System.out.println(Arrays.toString(printNewArr(arrInt, i)));
            return printNewArr(arrInt, i);
        } else {
            throw new RuntimeException();
        }
    }

    public static int findIndexFour(int[] arrInt) {
        for (int i = arrInt.length - 1; i >= 0; i--) {
            if (arrInt[i] == ex1) {
                return i;
            }
        }
        return 0;
    }

    public static int[] printNewArr(int[] arrInt, int i) {
        return Arrays.copyOfRange(arrInt, i + 1, arrInt.length - 0);
    }
}
