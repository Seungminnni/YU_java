package Homework_01;

import java.util.Scanner;

public class hw5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("총 초를 입력하세요: ");
        long totalSeconds = scanner.nextLong();

        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        System.out.printf("%02d:%02d:%02d\n", hours, minutes, seconds);

        scanner.close();
    }
}
