package Homework_02;

import java.util.Scanner;

public class hw_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("문자열을 입력하세요: ");
        String S = scanner.nextLine();
        
        StringBuilder result = new StringBuilder();
        int len = S.length();
        for (int i = 0; i < len; ) {
            char current = S.charAt(i);
            int count = 0;
            while (i < len && S.charAt(i) == current) {
                count++;
                i++;
            }
            result.append(current).append(count);
        }
        
        System.out.println(result.toString());
        
        scanner.close();
    }
}