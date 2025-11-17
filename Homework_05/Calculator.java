package Homework_05;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    private static void printMenu() {
        System.out.println();
        System.out.println("=== 계산기 메뉴 ===");
        System.out.println("1. 계산 수행 (두 정수 입력)");
        System.out.println("2. 종료");
        System.out.print("선택> ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            if (choice.equals("1")) {
                performCalculation(scanner);
            } else if (choice.equals("2")) {
                System.out.println("프로그램을 종료합니다.");
                running = false;
            } else {
                System.out.println("올바른 선택이 아닙니다. 1 또는 2를 입력하세요.");
            }
        }

        scanner.close();
    }

    private static void performCalculation(Scanner scanner) {
        System.out.println("두 개의 정수를 입력하고 연산자를 선택하세요.");

        while (true) {
            try {
                System.out.print("첫 번째 정수: ");
                String aLine = scanner.nextLine().trim();
                int a = Integer.parseInt(aLine);

                System.out.print("두 번째 정수: ");
                String bLine = scanner.nextLine().trim();
                int b = Integer.parseInt(bLine);

                System.out.print("연산자 입력 (+, -, *, /): ");
                String op = scanner.nextLine().trim();

                int result;
                switch (op) {
                    case "+":
                        result = a + b;
                        System.out.println(a + " + " + b + " = " + result);
                        break;
                    case "-":
                        result = a - b;
                        System.out.println(a + " - " + b + " = " + result);
                        break;
                    case "*":
                        result = a * b;
                        System.out.println(a + " * " + b + " = " + result);
                        break;
                    case "/":
                        // int 나누기에서 0으로 나누면 ArithmeticException 발생
                        result = a / b;
                        System.out.println(a + " / " + b + " = " + result);
                        break;
                    default:
                        System.out.println("지원하지 않는 연산자입니다. 다시 시도하세요.");
                        continue; // 연산자 잘못되면 다시 입력
                }

                // 정상 처리되면 메서드 종료하여 메뉴로 복귀
                return;

            } catch (NumberFormatException e) {
                System.out.println("입력 오류: 숫자가 아닌 값이 입력되었습니다. 정수를 입력해 주세요.");
                // 계속 루프하여 다시 입력 받음
            } catch (ArithmeticException e) {
                System.out.println("산술 오류: 0으로 나눌 수 없습니다. 다른 값을 입력하세요.");
                // 계속 루프하여 다시 입력 받음
            } catch (InputMismatchException e) {
                System.out.println("입력 형식 오류: 잘못된 입력입니다. 형식을 확인하세요.");
                scanner.nextLine(); // 남아있는 토큰 소비(안전)
            }
        }
    }
}
