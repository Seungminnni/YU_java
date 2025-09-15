package Practice_02;

import java.util.*;

public class Switch01 {
    public static void main(String[] args) {
        System.out.println("점수를 입력하시오:");

        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();

        switch(score / 10) {
            case 10:
            case 9:
                System.out.println("A학점입니다");
                break;
            case 8:
                System.out.println("B학점입니다");
                break;
            case 7:
                System.out.println("C학점입니다");
                break;
            case 6:
                System.out.println("D학점입니다");
                break;
            default:
                System.out.println("F학점입니다");
        }
    }
}
