package homeworkLesson14;

import java.util.HashSet;
import java.util.Set;

public class Ex2 {

    private static final int[] checkInt = {1, 4};

    public boolean checkNum(int[] arrInt) {

        Set<Integer> newSet = new HashSet();
        for (int i : arrInt) {
            newSet.add(i);
        }
        if (newSet.contains(checkInt[0]) && newSet.contains(checkInt[1]) && (newSet.size() == 2)){
            return true;
        }
        return false;
    }
}
