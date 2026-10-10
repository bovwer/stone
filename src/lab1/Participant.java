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


    public static void printParticipants() {
        if ( ParticipantService.participants == null ||  ParticipantService.participants.length ==0){
            System.out.println("Список участников пуст");
            return;
        }
        System.out.println("\n список всех участников олимпиады");
        for (Participant p :  ParticipantService.participants){
            System.out.println(p);
        }
    }
    public static void printPrizeSchools(){
        if ( ParticipantService.participants == null ||  ParticipantService.participants.length == 0) return;
        System.out.println("\n Школы с призовыми местами (1, 2, 3 места)");
        boolean found =false;
        for (Participant p :  ParticipantService.participants) {
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
    public static void schoolWithMaxPrizes() {
        if ( ParticipantService.participants == null ||  ParticipantService.participants.length == 0) return;


        int maxSchoolNum = 0;
        for (Participant p :  ParticipantService.participants) {
            if (p.getSchoolNumber() > maxSchoolNum) {
                maxSchoolNum = p.getSchoolNumber();
            }
        }


        int[] prizeCounts = new int[maxSchoolNum + 1];
        for (Participant p :  ParticipantService.participants) {
            if (p.getPlace() >= 1 && p.getPlace() <= 3) {
                prizeCounts[p.getSchoolNumber()]++;
            }
        }

        int bestSchool = -1;
        int maxPrizes = 0;
        for (int i = 0; i < prizeCounts.length; i++) {
            if (prizeCounts[i] > maxPrizes) {
                maxPrizes = prizeCounts[i];
                bestSchool = i;
            }
        }

        System.out.println("\n Школа с наибольшим числом призовых мест");
        if (bestSchool != -1) {
            System.out.println("Школа №" + bestSchool + " набрала больше всех призовых мест: " + maxPrizes);
        }
    }

    public static void sortAndPrintFirstPlaceWinners() {
        if ( ParticipantService.participants == null ||  ParticipantService.participants.length == 0) return;


        int count = 0;
        for (Participant p :  ParticipantService.participants) {
            if (p.getPlace() == 1) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("\n Участников, занявших 1 место, нет.");
            return;
        }


        Participant[] winners = new Participant[count];
        int idx = 0;
        for (Participant p :  ParticipantService.participants) {
            if (p.getPlace() == 1) {
                winners[idx++] = p;
            }
        }





        for (int i = 0; i < winners.length - 1; i++) {
            for (int j = 0; j < winners.length - 1 - i; j++) {
                if (winners[j].getGrade() > winners[j + 1].getGrade()) {
                    Participant temp = winners[j];
                    winners[j] = winners[j + 1];
                    winners[j + 1] = temp;
                }
            }
        }

        System.out.println("\nУчастники, занявшие 1-е место (отсортированы по классу)");
        for (Participant p : winners) {
            System.out.println("Класс: " + p.getGrade() + " | Участник: " + p.getLastName() + " (Школа №" + p.getSchoolNumber() + ")");
        }
    }

}
