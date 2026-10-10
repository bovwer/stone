package lab1;

import java.util.Scanner;

public class Participant {

    private String lastName;
    private int schoolNumber;
    private int grade;
    private int place;




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



}
