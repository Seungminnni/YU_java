package Practice_02;

import java.util.*;
public class Loop01 {
    public static void main(String[] args) {

        int sum = 0;
        System.out.print("5개의 숫자를 입력하세요: ");

        for (int n = 1; n <= 5; n++) {
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            sum += num;
            
        }
        System.out.println("합계: " + sum);


    }
}
