package Practice_02;

import java.util.*;

public class If04 {
    public static void main(String[] args) {
        System.out.println("3개의 숫자를 입력하시오");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        if(x > y){
            if(x > z){
                System.out.println("가장 큰 수는 "+x+"입니다");
            } 
            else{
                System.out.println(x+"는 가장 큰 수가 아닙니다");
            }
        } 
        else{
            System.out.println(x+"는 가장 큰 수가 아닙니다");
        }
    }
    
}
