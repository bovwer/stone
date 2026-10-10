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
}
