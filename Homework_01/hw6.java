package Homework_01;

import java.util.Scanner;

public class hw6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 a를 입력하세요: ");
        int a = scanner.nextInt();
        System.out.print("정수 b를 입력하세요: ");
        int b = scanner.nextInt();

        System.out.println("sum = " + (a + b));
        System.out.println("diff = " + (a - b));
        System.out.println("prod = " + (a * b));
        System.out.println("quot = " + (a / b));
        System.out.println("rem = " + (a % b));
        scanner.close();
        
    }
}
