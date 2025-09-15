package Practice_02;

import java.util.*;
public class If02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하시오");
        int num = scanner.nextInt();

        if(num % 2==0){
            System.out.println(num+"은 짝수입니다");
        } else{
            System.out.println(num+"은 홀수입니다");
        }
        System.out.println("이 문장은 if문 외부에 있습니다");
    }
}
    
