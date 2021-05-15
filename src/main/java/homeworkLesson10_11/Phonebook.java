package homeworkLesson10_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    private Map<String, String> phoneBook;

    public Phonebook() {
        this.phoneBook = new HashMap<String, String>();
    }

    void add(String surname, String number) {
        phoneBook.put(number, surname);
    }

    public void get(String surname) {
        ArrayList<String> arrayListNumber = new ArrayList<>();

        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (surname.equals(entry.getValue())) {
                arrayListNumber.add(entry.getKey());
            }
        }
        if (arrayListNumber.isEmpty()) {
            System.out.println("Данного контакта в базе нет. Увы.");
        } else {
            System.out.println(surname + " : " + arrayListNumber);
        }
    }
}
