package Practice_02;

import java.util.*;

public class If01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("나이를 입력하시오");
        int age = scanner.nextInt();

        if(age>=18){
            System.out.println("성인입니다");
            System.out.println("당신은 투표할 자격이 있습니다");
        }
        System.out.println("이 문장은 if문 외부에 있습니다");
        
        
    }
    
}
