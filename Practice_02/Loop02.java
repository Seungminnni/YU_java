package Practice_02;
import java.util.*;
public class Loop02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice ==1){
            int a;
            System.out.print("숫자를 입력하세요: ");
            a = scanner.nextInt();

            if (a % 2 == 0) {
                System.out.println(a + "은 짝수입니다");
            } else {
                System.out.println(a + "은 홀수입니다");
            }
            System.out.print("계속하시겠습니까? (1: 예, 0: 아니오): ");
            choice = scanner.nextInt();
        }
        scanner.close();
        System.out.println("모든 숫자를 확인했습니다.");

        
    }
    
}
