package lab1;

import java.util.Scanner;

public class Participant {

    private String lastName;
    private int schoolNumber;
    private int grade;
    private int place;


    public static Participant[] participants;

    static {

        participants = new Participant[]{
                new Participant("Иванов", 12, 11, 1),
                new Participant("Петров", 5, 10, 2),
                new Participant("Сидоров", 12, 9, 3),
                new Participant("Смирнов", 5, 11, 1),
                new Participant("Кузнецов", 12, 10, 1),
        };
    }


    public Participant(String lastName, int schoolNumber, int grade, int place) {
        setLastName(lastName);
        setSchoolNumber(schoolNumber);
        setGrade(grade);
        setPlace(place);
    }

    public Participant() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите фамилию");
        setLastName(scanner.nextLine());
        System.out.print("Введите номер школы");
        setSchoolNumber(scanner.nextInt());
        System.out.print("Введите класс 1-11");
        setGrade(scanner.nextInt());
        System.out.print("Введите занятое место");
        setPlace(scanner.nextInt());
    }

    @Override
    public String toString() {
        return String.format("Участник: %12s | Школа: №%-3d | Класс: %-2d | Место: %d", lastName, schoolNumber, grade, place);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            System.out.println("Фамилия не может быть пустой");
            this.lastName = "Неизвестно";
        } else {
            this.lastName = lastName;

        }
    }

    public int getSchoolNumber() {
        return schoolNumber;

    }

    public void setSchoolNumber(int schoolNumber) {
        if (schoolNumber <0) {
            System.out.println("номер должен быть положительным");
            this.schoolNumber = 1;}
        else {this.schoolNumber =schoolNumber;

        }

    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade<1 || grade>11) {
            System.out.println("Класс должен быть от 1 до 11");
            this.grade=1;
        } else {
            this.grade = grade;
        }
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        if (place<=0) {
            System.out.println("Занятое место должно быть больше нуля");
            this.place= 999;
        } else {
            this.place = place;

        }
    }
    public static void fillParticipants() {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Введите количество участников: ");
        int n = scanner.nextInt();
        participants = new Participant[n];
        for (int i= 0; i<n; i++) {
            System.out.println("\n Ввод данных для участника №" + (i+1) + ":");
            participants[i] = new Participant();
        }
    }
    public static void printParticipants() {
        if (participants == null || participants.length ==0){
            System.out.println("Список участников пуст");
            return;
        }
        System.out.println("\n список всех участников олимпиады");
        for (Participant p : participants){
            System.out.println(p);
        }
    }
    public static void printPrizeSchools(){
        if (participants == null || participants.length == 0) return;
        System.out.println("\n Школы с призовыми местами (1, 2, 3 места)");
        boolean found =false;
        for (Participant p : participants) {
            if (p.getPlace() >= 1 && p.getPlace() <=3) {
                System.out.println("Школа №" + p.getSchoolNumber() +
                        " Участник: " + p.getLastName() +
                        " Место: " + p.getPlace());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Призовых мест не найдено");
        }
    }
}