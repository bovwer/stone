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

}
