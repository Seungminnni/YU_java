package Homework_01;

import java.util.Scanner;

public class hw10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int naiveAvg = (a + b + c) / 3;
        double correctAvg = ((long)a + b + c) / 3.0;
        long safeAvg = ((long)a + b + c) / 3;

        long expr1 = (long)b * c;
        long expr2 = ((long)a + b) * c;

        System.out.println("naiveAvg = " + naiveAvg);
        System.out.printf("correctAvg = %.1f\n", correctAvg);
        System.out.printf("safeAvg = %.1f\n", (double)safeAvg);
        System.out.println("expr1 = " + expr1);
        System.out.println("expr2 = " + expr2);

        scanner.close();
    }
    
}