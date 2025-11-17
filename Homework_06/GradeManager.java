package Homework_06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GradeManager {

    private static final Path STUDENTS_FILE = Paths.get("students.txt");

    private static class Student {
        String name;
        Map<String, Integer> scores = new HashMap<>();

        Student(String name) { this.name = name; }

        double average() {
            if (scores.isEmpty()) return 0.0;
            int sum = 0;
            for (int v : scores.values()) sum += v;
            return (double) sum / scores.size();
        }

        String grade(double avg) {
            int a = (int) Math.round(avg);
            char base;
            if (a >= 90) base = 'A';
            else if (a >= 80) base = 'B';
            else if (a >= 70) base = 'C';
            else if (a >= 60) base = 'D';
            else base = 'F';

            if (base == 'F') return "F";
            int ones = a % 10;
            String plusMinus = "";
            if (ones >= 7) plusMinus = "+";
            else if (ones <= 2) plusMinus = "-";
            return base + plusMinus;
        }
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Map<String, Student> studentMap = new HashMap<>();

        int loaded = loadStudents(studentList, studentMap);
        System.out.println("=== 성적 관리 시스템 ===");
        System.out.println("students.txt에서 " + loaded + "명의 학생 데이터를 불러왔습니다.");

        try (Scanner sc = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println();
                System.out.println("1. 학생 추가");
                System.out.println("2. 성적 입력");
                System.out.println("3. 학생별 성적 조회");
                System.out.println("4. 과목별 평균");
                System.out.println("5. 전체 저장");
                System.out.println("6. 종료");
                System.out.print("선택: ");

                String choice = sc.nextLine().trim();
                switch (choice) {
                    case "1": 
                        System.out.print("학생 이름: ");
                        String name = sc.nextLine().trim();
                        if (name.isEmpty()) { System.out.println("이름을 입력하세요."); break; }
                        if (studentMap.containsKey(name)) {
                            System.out.println("이미 등록된 학생입니다.");
                        } else {
                            Student s = new Student(name);
                            studentList.add(s);
                            studentMap.put(name, s);
                            System.out.println("[등록 완료] " + name);
                        }
                        break;

                    case "2": 
                        System.out.print("학생 이름: ");
                        String tname = sc.nextLine().trim();
                        if (!studentMap.containsKey(tname)) {
                            System.out.println("등록되지 않은 학생입니다."); break;
                        }
                        Student st = studentMap.get(tname);
                        System.out.print("과목명: ");
                        String subj = sc.nextLine().trim();
                        if (subj.isEmpty()) { System.out.println("과목명을 입력하세요."); break; }
                        System.out.print("점수: ");
                        String sscore = sc.nextLine().trim();
                        try {
                            int score = Integer.parseInt(sscore);
                            if (score < 0 || score > 100) { System.out.println("0-100 사이의 점수를 입력하세요."); break; }
                            st.scores.put(subj, score);
                            System.out.println("[처리 완료] " + tname + " - " + subj + ": " + score + "점");
                        } catch (NumberFormatException e) {
                            System.out.println("유효한 점수를 입력하세요.");
                        }
                        break;

                    case "3": // 학생별 성적 조회
                        System.out.print("학생 이름: ");
                        String qname = sc.nextLine().trim();
                        if (!studentMap.containsKey(qname)) { System.out.println("등록되지 않은 학생입니다."); break; }
                        Student q = studentMap.get(qname);
                        System.out.println("[" + q.name + " 성적표]");
                        if (q.scores.isEmpty()) {
                            System.out.println("(입력된 성적이 없습니다)");
                        } else {
                            List<String> subs = new ArrayList<>(q.scores.keySet());
                            Collections.sort(subs);
                            for (String s : subs) {
                                System.out.println(s + ": " + q.scores.get(s) + "점");
                            }
                            double avg = q.average();
                            String grade = q.grade(avg);
                            System.out.printf("평균: %.1f점 (등급: %s)%n", avg, grade);
                        }
                        break;

                    case "4": 
                        System.out.print("조회할 과목: ");
                        String subjQ = sc.nextLine().trim();
                        if (subjQ.isEmpty()) { System.out.println("과목명을 입력하세요."); break; }
                        System.out.println("[" + subjQ + " 과목 통계]");
                        double sum = 0; int cnt = 0;
                        for (Student s : studentList) {
                            if (s.scores.containsKey(subjQ)) {
                                System.out.println("- " + s.name + ": " + s.scores.get(subjQ) + "점");
                                sum += s.scores.get(subjQ);
                                cnt++;
                            }
                        }
                        if (cnt == 0) System.out.println("해당 과목의 성적이 없습니다.");
                        else System.out.printf("평균: %.1f점%n", sum / cnt);
                        break;

                    case "5":
                        int saved = saveStudents(studentList);
                        System.out.println("students.txt에 " + saved + "명의 데이터를 저장했습니다.");
                        break;

                    case "6":
                        System.out.println("프로그램을 종료합니다.");
                        running = false;
                        break;

                    default:
                        System.out.println("올바른 선택이 아닙니다. 1~6 중 선택하세요.");
                }
            }
        }
    }

    private static int loadStudents(List<Student> list, Map<String, Student> map) {
        if (!Files.exists(STUDENTS_FILE)) {
            try { Files.write(STUDENTS_FILE, new ArrayList<>(), StandardCharsets.UTF_8); } catch (IOException e) { }
            return 0;
        }

        try {
            List<String> lines = Files.readAllLines(STUDENTS_FILE, StandardCharsets.UTF_8);
            Student current = null; int count = 0;
            for (String raw : lines) {
                String line = raw.trim();
                if (line.isEmpty()) continue;
                if (line.equals("---")) { if (current != null) { list.add(current); map.put(current.name, current); current = null; count++; } continue; }
                if (current == null) {
                    current = new Student(line);
                } else {
                    int idx = line.indexOf(':');
                    if (idx > 0) {
                        String subj = line.substring(0, idx).trim();
                        String sc = line.substring(idx + 1).trim();
                        try { int score = Integer.parseInt(sc); current.scores.put(subj, score); } catch (NumberFormatException e) { }
                    }
                }
            }

            if (current != null) { list.add(current); map.put(current.name, current); count++; }
            return count;
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
            return 0;
        }
    }

    private static int saveStudents(List<Student> list) {
        List<String> out = new ArrayList<>();
        for (Student s : list) {
            out.add(s.name);

            List<String> subs = new ArrayList<>(s.scores.keySet());
            Collections.sort(subs);
            for (String sub : subs) {
                out.add(sub + ":" + s.scores.get(sub));
            }
            out.add("---");
        }
        try {
            Files.write(STUDENTS_FILE, out, StandardCharsets.UTF_8);
            return list.size();
        } catch (IOException e) {
            System.out.println("파일 저장 오류: " + e.getMessage());
            return 0;
        }
    }
}
