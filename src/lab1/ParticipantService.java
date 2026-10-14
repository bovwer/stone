package lab1;

import java.util.Scanner;

public class ParticipantService {
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
    public static void fillParticipants() {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Введите количество участников: ");
        int n = scanner.nextInt();
        ParticipantService.participants = new Participant[n];
        for (int i= 0; i<n; i++) {
            System.out.println("\n Ввод данных для участника №" + (i+1) + ":");
            ParticipantService.participants[i] = new Participant();
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



    public static Participant searchByLastName(String lastName) {
        System.out.println("Поиск участника в master: " + lastName);
        if (participants == null || participants.length == 0) {
            return null;
        }
        for (int i = 0; i < participants.length; i++) {
            if (participants[i].getLastName().equals(lastName)) {
                return participants[i];
            }
        }
        return null;
    }
}
