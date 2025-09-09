package Homework_01;

import java.util.Scanner;

public class hw8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("세 과목의 점수를 입력하시오 Ex)90 80 70:");
        int s1 = scanner.nextInt();
        int s2 = scanner.nextInt();
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