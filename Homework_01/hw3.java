package Homework_01;

import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("섭씨 온도를 입력하시오: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.printf("C= %.1f F= %.1f\n", celsius,fahrenheit);
    }
}
