package Homework_02;

import java.util.Scanner;

public class hw_1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            long N = sc.nextLong();
            
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
        }
    }
}
