package Homework_03;

public class hw1 {
    public static String format(String digits) {
        int len = digits.length();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = digits.charAt(i) - '0';
        }
        return format(arr);
    }
    
    public static String format(int[] digits) {
        int len = digits.length;
        StringBuilder sb = new StringBuilder();
        switch (len) {
            case 11 -> {
                // 010-1234-5678
                for (int i = 0; i < 3; i++) sb.append(digits[i]);
                sb.append("-");
                for (int i = 3; i < 7; i++) sb.append(digits[i]);
                sb.append("-");
                for (int i = 7; i < 11; i++) sb.append(digits[i]);
            }
            case 10 -> {
                // 011-123-4567
                for (int i = 0; i < 3; i++) sb.append(digits[i]);
                sb.append("-");
                for (int i = 3; i < 6; i++) sb.append(digits[i]);
                sb.append("-");
                for (int i = 6; i < 10; i++) sb.append(digits[i]);
            }
            default -> throw new IllegalArgumentException("Invalid phone number length: " + len);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("휴대전화 번호를 입력하세요 (숫자만): ");
        String input = scanner.nextLine();
        String formatted = format(input);
        System.out.println("포맷된 번호: " + formatted);
        scanner.close();
    }
}