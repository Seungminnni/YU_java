package Homework_05;

import java.util.Scanner;

public class CircleStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = 0.0;
        if (scanner.hasNextDouble()) {
            r = scanner.nextDouble();
        } else if (scanner.hasNextLine()) {
            r = Double.parseDouble(scanner.nextLine().trim());
        }

        double area = Math.PI * r * r; // 원의 넓이
        double circumference = 2 * Math.PI * r; // 원의 둘레
        double squareArea = r * r; // 반지름을 한 변으로 하는 정사각형의 넓이
        double sqrtR = Math.sqrt(r); // 반지름의 제곱근

        System.out.printf("원의 넓이: %.2f%n", area);
        System.out.printf("원의 둘레: %.2f%n", circumference);
        System.out.printf("정사각형 넓이: %.2f%n", squareArea);
        System.out.printf("반지름의 제곱근: %.2f%n", sqrtR);

        scanner.close();
    }
}
