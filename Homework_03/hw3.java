package Homework_03;

import java.util.Scanner;

public class hw3 {
    
    public static String parse(String rrn) {
        return parse(rrn, false);
    }
    
    public static String parse(String rrn, boolean verbose) {
        if (rrn == null) {
            return verbose ? "오류: 입력이 null입니다." : null;
        }
        String[] parts = rrn.split("-");
        if (parts.length != 2) {
            return verbose ? "오류: 하이픈이 하나여야 합니다." : null;
        }
        String front = parts[0];
        String back = parts[1];
        if (front.length() != 6 || back.length() != 7) {
            return verbose ? "오류: 앞 6자리, 뒤 7자리여야 합니다." : null;
        }
        String digits = front + back;
        for (char c : digits.toCharArray()) {
            if (!Character.isDigit(c)) {
                return verbose ? "오류: 숫자만 입력하세요." : null;
            }
        }
        int year = Integer.parseInt(front.substring(0, 2));
        int genderCode = back.charAt(0) - '0';
        if (genderCode < 1 || genderCode > 4) {
            return verbose ? "오류: 성별 코드가 1-4여야 합니다." : null;
        }
        int birthYear = (genderCode == 1 || genderCode == 2) ? 1900 + year : 2000 + year;
        String gender = (genderCode % 2 == 1) ? "남" : "여";
        return "출생년도: " + birthYear + ", 성별: " + gender;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = parse(input);
        if (result == null) {
            System.out.println("Invalid");
        } else {
            System.out.println("Valid");
            String[] parts = result.split(", ");
            String yearPart = parts[0].split(": ")[1];
            String genderPart = parts[1].split(": ")[1];
            System.out.println("Year=" + yearPart);
            System.out.println("Gender=" + genderPart);
        }
        scanner.close();
    }
}
