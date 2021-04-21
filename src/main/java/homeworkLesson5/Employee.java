package homeworkLesson5;

public class Employee {
    private static int employeeCount = 0;

    //* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
    private String FIO;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    //    constructor
    public Employee() {
        this.FIO = "Анонимов Аноним Анонимович";
        this.position = "Анонимист";
        this.email = "anonymus@anon.com";
        this.phoneNumber = "6-666-666-66-66";
        this.salary = 0;
        this.age = 1;
        employeeCount++;
    }

    public Employee(String FIO, String position, String email, String phoneNumber, int salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
        employeeCount++;
    }

    public void printInfo() {
        System.out.print(this);
        System.out.println("------------------------------------");
    }

    @Override
    public String toString() {
        return String.format("""
                ФИО: %s, 
                Должность: %s, 
                Email: %s, 
                Телефонный номер: %s, 
                Зарплата: %d у.е., 
                Возраст: %d years.\n""", FIO, position, email, phoneNumber, salary, age);
    }

    void forYears(int age){
            if (this.age >= age){
                printInfo();
        }
    }
}
