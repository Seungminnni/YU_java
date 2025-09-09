package Homework_01;

import java.util.Scanner;

public class hw8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫번째 과목의 점수를 입력하시오:");
        int s1 = scanner.nextInt();
        System.out.print("두번째 과목의 점수를 입력하시오:");
        int s2 = scanner.nextInt();
        System.out.print("세번째 과목의 점수를 입력하시오:");
        int s3 = scanner.nextInt();

        double avg = (s1 + s2 + s3) / 3;

        char grade = (avg >= 90) ? 'A' :
                     (avg >= 80) ? 'B' :
                     (avg >= 70) ? 'C' :
                     (avg >= 60) ? 'D' : 'F';

        System.out.println("avg = "+ avg);
        System.out.println("grade = "+ grade);

        scanner.close();
    }
}