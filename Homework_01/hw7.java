package Homework_01;

import java.util.Scanner;
import java.lang.Math;

public class hw7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("반지름을 입력하시오: ");
        double radius = scanner.nextDouble();
        
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;
        
        System.out.printf("area=%.2f\n", area);
        System.out.printf("circum=%.2f\n", circumference);

        scanner.close();
    }

}
