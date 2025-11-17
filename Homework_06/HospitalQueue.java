package Homework_06;

import java.util.LinkedList;
import java.util.Scanner;

public class HospitalQueue {

    private static class Patient {
        int ticket;
        String name;

        Patient(int ticket, String name) {
            this.ticket = ticket;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Patient> queue = new LinkedList<>();
        int nextTicket = 1;
        boolean running = true;

        while (running) {
            System.out.println("=== 병원 대기열 시스템 ===");
            System.out.println("1. 환자 접수");
            System.out.println("2. 진료 완료");
            System.out.println("3. 대기 인원 확인");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("환자 이름: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("이름을 입력하세요.");
                    } else {
                        Patient p = new Patient(nextTicket++, name);
                        queue.addLast(p);
                        System.out.println("[접수 완료] 대기번호 " + p.ticket + "번 - " + p.name);
                    }
                    break;
                case "2":
                    if (queue.isEmpty()) {
                        System.out.println("현재 대기중인 환자가 없습니다.");
                    } else {
                        Patient served = queue.removeFirst();
                        System.out.println("[진료 완료] " + served.name + "님 진료가 끝났습니다.");
                    }
                    break;
                case "3":
                    System.out.println("[현재 대기 인원: " + queue.size() + "명]");
                    if (queue.isEmpty()) {
                        // nothing more
                    } else {
                        for (Patient p : queue) {
                            System.out.println(p.ticket + "번 - " + p.name);
                        }
                    }
                    break;
                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("올바른 선택이 아닙니다. 1~4 중 선택하세요.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
