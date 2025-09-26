package Homework_03;

import java.util.Scanner;

public class hw7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int G = scanner.nextInt();
        int[] a = new int[M];
        for (int i = 0; i < M; i++) a[i] = scanner.nextInt();

        int bestStart = 0;
        int bestLen = 0;

        int curStart = -1;
        int curLen = 0;
        for (int i = 0; i < M; i++) {
            if (a[i] == 0) {
                if (curLen == 0) curStart = i + 1;
                curLen++;
            } else {
                if (curLen > bestLen) {
                    bestLen = curLen;
                    bestStart = curStart;
                }
                curLen = 0;
            }
        }
        // 마지막 구간 확인
        if (curLen > bestLen) {
            bestLen = curLen;
            bestStart = curStart;
        }

        // (2) 첫번째 G 이상의 연속 구간 찾기
        int groupStart = -1;
        curStart = -1;
        curLen = 0;
        for (int i = 0; i < M; i++) {
            if (a[i] == 0) {
                if (curLen == 0) curStart = i + 1;
                curLen++;
                if (curLen >= G) {
                    groupStart = curStart;
                    break;
                }
            } else {
                curLen = 0;
            }
        }

        if (bestStart == 0) {
            System.out.println("LongestStart=0");
        } else {
            System.out.println("LongestStart=" + bestStart);
        }
        System.out.println("LongestLen=" + bestLen);
        if (groupStart == -1) {
            System.out.println("GroupStart=-1");
        } else {
            System.out.println("GroupStart=" + groupStart);
        }

        scanner.close();
    }
}
