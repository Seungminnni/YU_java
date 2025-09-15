package Practice_02;

import java.util.*;

public class Input01{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int n = scanner.nextInt();
        
        System.out.print("실수를 입력하세요: ");
        double db = scanner.nextDouble();
        System.out.println("정수값: " + n);
        System.out.println("실수값: " + db);
        
        scanner.close();
    }
}