package homeworkLesson5;

import java.util.Scanner;

public class Main {
    static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Employee[] staffArray = new Employee[5];
        staffArray[0] = new Employee("Иванов Иван", "Инженер", "ivivan@mailbox.com", "892312312", 30000, 45);
        staffArray[1] = new Employee();
        staffArray[2] = new Employee("Мысин Олег Денисович", "Сотрудник", "7nacu7@gmail.com", "8-999-604-**-**", 100000, 24);
        staffArray[3] = new Employee("Алексей Викторович Колесник", "Надзиратель", "none", "8-999-6654-78-12", 195377, 42);
        staffArray[4] = new Employee("Человеков Человек Человекович", "Человек", "human@hum.com", "69-69-96", 0, 100);

        whoForYears(staffArray);
    }

    private static void whoForYears(Employee[] staffArray) {
        System.out.println("Сотрудников старше(>=) скольки лет вывести на экран?");
        int age = in.nextInt();
        System.out.printf("Сотрудники старше %d лет:\n", age);
        for (Employee employee : staffArray) {
            employee.forYears(age);
        }
    }
}
