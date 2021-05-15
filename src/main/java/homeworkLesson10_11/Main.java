package homeworkLesson10_11;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        hwEx1();
        hwEx2();
        
    }

    private static void hwEx1() {
        System.out.println("Задание №1");
        int count;

        String[] defArray = {"A", "B", "C", "D", "A", "B", "A", "X", "D", "B",
                "A", "Q", "W", "C", "D", "A", "A", "W", "X", "X"};

        Map<String, Integer> mapEx = new HashMap<>();

        for (String s : defArray) {
            count = 0;
            for (String s1 : defArray) {
                if (s.equals(s1)) {
                    count++;
                }
            }
            mapEx.put(s, count);
        }
        System.out.println("Исходный массив: " + Arrays.deepToString(defArray));
        System.out.println("Кол-во вхождений: " + mapEx);
    }

    private static void hwEx2() {
        System.out.println("Задание №2.");
        Phonebook phonebook = new Phonebook();

        phonebook.add("Мысин", "8-999-111-11-11");
        phonebook.add("Хапилина", "8-999-222-22-22");
        phonebook.add("Мысин", "8-999-333-33-33");
        phonebook.add("Иванов", "8-999-444-44-44");
        phonebook.add("Иванов", "8-999-555-55-55");
        phonebook.add("Мысин", "8-999-666-66-66");

        phonebook.get("Мысин");
        phonebook.get("Хапилина");
        phonebook.get("Иванов");
        phonebook.get("Петров");

    }
}
