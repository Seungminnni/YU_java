package Homework_01;

import java.util.Scanner;

public class hw9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("원화 금액과 환율을 입력해주시오 Ex)10000 1300.0:");
        
        long won = scanner.nextLong();
        double rate = scanner.nextDouble();

        double dollar = won / rate;
        System.out.printf("usd = %.2f\n", dollar);
        scanner.close();
    }
}
