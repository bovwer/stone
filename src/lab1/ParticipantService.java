package lab1;

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

}
