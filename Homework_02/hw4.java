package Homework_02;

import java.util.Scanner;

public class hw4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("N을 입력하세요: ");
        int N = scanner.nextInt();
        scanner.nextLine();
        
        int totalMinutes = 0;
        int in = 0;
        
        for (int i = 0; i < N; i++) {
            System.out.print((i % 2 == 0 ? "IN: " : "OUT: "));
            String time = scanner.nextLine();
            String type = i % 2 == 0 ? "IN" : "OUT";
            String line = type + " " + time;
            String[] parts = line.split(" ");
            String timeStr = parts[1];
            String[] hm = timeStr.split(":");
            int h = Integer.parseInt(hm[0]);
            int m = Integer.parseInt(hm[1]);
            int minutes = h * 60 + m;
            
            if (type.equals("IN")) {
                in = minutes;
            } else {
                totalMinutes += minutes - in;
            }
        }
        
        int fee = 600 * (int) Math.ceil(totalMinutes / 10.0) - 2000;
        
        System.out.println("Minutes=" + totalMinutes);
        System.out.println("Fee=" + fee);
        
        scanner.close();
    }
}