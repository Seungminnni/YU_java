package Homework_06;

import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("=== 출석 관리 시스템 ===");
            System.out.println("1. 학생 추가");
            System.out.println("2. 학생 삭제");
            System.out.println("3. 전체 학생 출력");
            System.out.println("4. 학생 검색");
            System.out.println("5. 종료");
            System.out.print("선택: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("학생 이름: ");
                    String nameToAdd = scanner.nextLine().trim();
                    if (nameToAdd.isEmpty()) {
                        System.out.println("이름을 입력하세요.");
                    } else {
                        students.add(nameToAdd);
                        System.out.println(nameToAdd + " 님이 추가되었습니다.");
                    }
                    break;
                case "2":
                    if (students.isEmpty()) {
                        System.out.println("등록된 학생이 없습니다.");
                        break;
                    }
                    System.out.print("삭제할 학생 이름: ");
                    String nameToRemove = scanner.nextLine().trim();
                    boolean removed = students.removeIf(s -> s.equalsIgnoreCase(nameToRemove));
                    if (removed) System.out.println(nameToRemove + " 님이 삭제되었습니다.");
                    else System.out.println("해당 학생을 찾을 수 없습니다: " + nameToRemove);
                    break;
                case "3":
                    System.out.println("[전체 학생 목록]");
                    if (students.isEmpty()) {
                        System.out.println("(등록된 학생이 없습니다)");
                    } else {
                        for (int i = 0; i < students.size(); i++) {
                            System.out.printf("%d. %s%n", i + 1, students.get(i));
                        }
                    }
                    break;
                case "4":
                    System.out.print("검색할 이름: ");
                    String nameToSearch = scanner.nextLine().trim();
                    int idx = -1;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).equalsIgnoreCase(nameToSearch)) {
                            idx = i;
                            break;
                        }
                    }
                    if (idx >= 0) {
                        System.out.println("결과: " + (idx + 1) + "번 - " + students.get(idx));
                    } else {
                        System.out.println("검색 결과가 없습니다: " + nameToSearch);
                    }
                    break;
                case "5":
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("올바른 선택이 아닙니다. 1~5 중 선택하세요.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
