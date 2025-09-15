package Practice_02;

import java.util.Scanner;

public class Loop03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("10보다 큰 숫자를 입력하세요");
        int x = scanner.nextInt();
        int sum = 0;
        
        do {
            sum += x;
            x--;
        }
        while (x >= 10);
        System.out.println("10부터 입력한 숫자까지의 합은 " + sum + "입니다");
    }
    
}
