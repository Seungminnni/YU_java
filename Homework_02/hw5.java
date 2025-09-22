package Homework_02;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class hw5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String firstLine = scanner.nextLine();
        String[] parts = firstLine.split(" ");
        int F = Integer.parseInt(parts[0]);
        int S = Integer.parseInt(parts[1]);
        
        Queue<String> calls = new LinkedList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("STOP")) {
                break;
            }
            calls.add(line);
        }
        
        int current = S;
        int totalDistance = 0;
        int stops = 0;
        
        while (!calls.isEmpty()) {
            String call = calls.poll();
            if (call.startsWith("CALL ")) {
                try {
                    int floor = Integer.parseInt(call.substring(5));
                    if (floor < 1 || floor > F) {
                        System.out.println("Ignored");
                    } else {
                        int dist = Math.abs(current - floor);
                        totalDistance += dist;
                        current = floor;
                        stops++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ignored");
                }
            } else {
                System.out.println("Ignored");
            }
        }
        
        System.out.println("Stops=" + stops);
        System.out.println("Distance=" + totalDistance);
        
        scanner.close();
    }
}