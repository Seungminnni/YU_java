package Homework_01;

import java.util.Scanner;

public class hw4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("첫 번째 정수를 입력하세요: ");
        int a = scanner.nextInt();
        
        System.out.print("두 번째 정수를 입력하세요: ");
        int b = scanner.nextInt();

        System.out.println("Before: a=" + a + ", b=" + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("After: a=" + a + ", b=" + b);
        
        scanner.close();
    }
}
