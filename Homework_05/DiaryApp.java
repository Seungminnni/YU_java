package Homework_05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DiaryApp {

    private static void printMenu() {
        System.out.println("=== 일기장 프로그램 ===");
        System.out.println("1. 일기 쓰기");
        System.out.println("2. 일기 읽기");
        System.out.println("3. 종료");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("선택: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> writeDiary(scanner);
                case "2" -> readDiary(scanner);
                case "3" -> {
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                }
                default -> System.out.println("올바른 선택입니다. 1~3 중 선택하세요.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void writeDiary(Scanner scanner) {
        System.out.print("날짜 입력 (YYYYMMDD): ");
        String date = scanner.nextLine().trim();
        if (date.isEmpty()) {
            System.out.println("날짜를 입력해야 합니다.");
            return;
        }

        System.out.print("제목 입력: ");
        String title = scanner.nextLine().trim();

        System.out.print("내용 입력: ");
        String content = scanner.nextLine().trim();

        String filename = "diary_" + date + ".txt";

        try (FileWriter fw = new FileWriter(filename);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("날짜: " + date);
            bw.newLine();
            bw.write("제목: " + title);
            bw.newLine();
            bw.write("내용: " + content);
            bw.newLine();
            System.out.println("저장 완료! (" + filename + ")");
        } catch (IOException e) {
            System.out.println("[오류] 파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static void readDiary(Scanner scanner) {
        System.out.print("파일 이름 입력: ");
        String filename = scanner.nextLine().trim();
        if (filename.isEmpty()) {
            System.out.println("파일 이름을 입력해야 합니다.");
            return;
        }

        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {
            System.out.println();
            System.out.println("===== 일기 내용 =====");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("===================");
        } catch (FileNotFoundException e) {
            System.out.println("[오류] 파일이 존재하지 않습니다: " + filename);
        } catch (IOException e) {
            System.out.println("[오류] 파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}