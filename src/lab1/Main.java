package lab1;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);

        cycle: while (true) {
            System.out.println("\n Выберите нужный пункт");
            System.out.println("1. Заполнить массив участников с клавиатуры");
            System.out.println("2. Распечатать список всех участников");
            System.out.println("3. (а) Показать школы, занявшие призовые места");
            System.out.println("4. (б) Найти школу с наибольшим числом призовых мест");
            System.out.println("5. (в) Отсортировать и вывести обладателей 1-х мест по классам");
            System.out.println("6. Выход");
            System.out.print("Выберите пункт меню (1 - 6): ");

            if (!sc.hasNextInt()) {
                System.out.println("Ошибка! Введите число от 1 до 6.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ParticipantService.fillParticipants();
                    break;
                case 2:
                    ParticipantService.printParticipants();
                    break;
                case 3:
                    ParticipantService.printPrizeSchools();
                    break;
                case 4:
                    ParticipantService.schoolWithMaxPrizes();
                    break;
                case 5:
                    Participant.sortAndPrintFirstPlaceWinners();
                    break;
                case 6:
                    System.out.println("Программа завершена.");
                    break cycle;
                default:
                    System.out.println("Неверный пункт меню. Введите число от 1 до 6.");
                    break;
            }
        }
        sc.close();
    }
}
