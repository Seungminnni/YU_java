package Homework_03;

import java.util.Scanner;

public class hw6 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int W = scanner.nextInt();
        int T = scanner.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }

        long thresholdSum = (long) T * W; 
        long sum = 0;
        int foundIdx = 0; 

        
        for (int i = 0; i < Math.min(W, N); i++) sum += a[i];
        if (W <= N && sum >= thresholdSum) {
            foundIdx = 1;
        }

        for (int i = W; foundIdx == 0 && i < N; i++) {
            sum += a[i];
            sum -= a[i - W];
            if (sum >= thresholdSum) {
                foundIdx = i - W + 2; 
                break;
            }
        }

        if (foundIdx == 0) {
            System.out.println("Index=0");
            System.out.println("Avg=0.0");
        } else {
            System.out.println("Index=" + foundIdx);
            
            int start = foundIdx - 1; 
            long s = 0;
            for (int i = start; i < start + W; i++) s += a[i];
            double avg = (double) s / W;
            double rounded = Math.round(avg * 10.0) / 10.0;
            System.out.println(String.format("Avg=%.1f", rounded));
        }

        scanner.close();
    }
}
