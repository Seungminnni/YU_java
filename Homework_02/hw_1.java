package Homework_02;

import java.util.Scanner;

public class hw_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("N을 입력하세요: ");
        long N = scanner.nextLong();
        
        int count = 1;
        long max = N;
        
        while (N != 1) {
            if (N % 2 == 0) {
                N = N / 2;
            } else {
                N = 3 * N + 1;
            }
            count++;
            if (N > max) {
                max = N;
            }
        }
        
        System.out.println("Length=" + count);
        System.out.println("Max=" + max);
        
        scanner.close();
    }
}
