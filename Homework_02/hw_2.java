package Homework_02;

import java.util.Scanner;

public class hw_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("N을 입력하세요: ");
        int N = scanner.nextInt();
        
        // 상단 부분
        for (int i = 0; i <= N / 2; i++) {
            // 왼쪽 공백
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // 별
            for (int j = 0; j < N - 2 * i; j++) {
                System.out.print("*");
            }
            // 오른쪽 공백
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        
        // 하단 부분
        for (int i = 0; i <= N / 2; i++) {
            // 왼쪽 공백
            for (int j = 0; j < N / 2 - i; j++) {
                System.out.print(" ");
            }
            // 별
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            // 오른쪽 공백
            for (int j = 0; j < N / 2 - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}