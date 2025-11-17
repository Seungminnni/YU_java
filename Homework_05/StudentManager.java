package Homework_05;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class StudentManager {

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + " - " + score;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            printMenu();
            System.out.print("선택> ");
            String input = sc.nextLine().trim();

            if (input.equals("1")) {
                addStudent(sc, students);
            } else if (input.equals("2")) {
                deleteStudent(sc, students);
            } else if (input.equals("3")) {
                listStudents(students);
            } else if (input.equals("4")) {
                printAverage(students);
            } else if (input.equals("5")) {
                printTopStudents(students);
            } else if (input.equals("6")) {
                System.out.println("프로그램 종료");
                break;
            } else {
                System.out.println("잘못된 선택입니다. 메뉴를 다시 선택하세요.");
            }

            System.out.println();
        }

        sc.close();
    }

    private static void printMenu() {
        System.out.println("===== 학생 관리 프로그램 =====");
        System.out.println("1. 학생 추가");
        System.out.println("2. 학생 삭제");
        System.out.println("3. 전체 학생 목록 출력");
        System.out.println("4. 평균 점수 계산");
        System.out.println("5. 최고 점수 학생 찾기");
        System.out.println("6. 종료");
    }

    private static void addStudent(Scanner sc, ArrayList<Student> students) {
        System.out.print("학생 이름: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("이름이 비어 있습니다. 추가 취소.");
            return;
        }

        System.out.print("점수(정수 0-100): ");
        String scoreStr = sc.nextLine().trim();
        int score;
        try {
            score = Integer.parseInt(scoreStr);
            if (score < 0 || score > 100) {
                System.out.println("점수는 0에서 100 사이여야 합니다. 추가 취소.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("유효한 정수 점수가 아닙니다. 추가 취소.");
            return;
        }

        students.add(new Student(name, score));
        System.out.println("학생이 추가되었습니다: " + name + " (" + score + ")");
    }

    private static void deleteStudent(Scanner sc, ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        System.out.print("삭제할 학생 이름: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("이름을 입력하지 않았습니다. 삭제 취소.");
            return;
        }

        int idx = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).name.equalsIgnoreCase(name)) {
                idx = i;
                break;
            }
        }

        if (idx >= 0) {
            Student removed = students.remove(idx);
            System.out.println("삭제되었습니다: " + removed.name + " (" + removed.score + ")");
        } else {
            System.out.println("해당 이름의 학생을 찾지 못했습니다: " + name);
        }
    }

    private static void listStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        System.out.println("전체 학생 목록:");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.printf("%d. %s (점수: %d)%n", i + 1, s.name, s.score);
        }
    }

    private static void printAverage(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        int sum = 0;
        for (Student s : students) sum += s.score;
        double avg = (double) sum / students.size();
        System.out.printf(Locale.US, "평균 점수: %.2f\n", avg);
    }

    private static void printTopStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        int max = Integer.MIN_VALUE;
        for (Student s : students) {
            if (s.score > max) max = s.score;
        }

        System.out.println("최고 점수: " + max);
        System.out.println("최고 점수 학생(들):");
        for (Student s : students) {
            if (s.score == max) System.out.println("- " + s.name + " (" + s.score + ")");
        }
    }
}
