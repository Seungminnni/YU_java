package Practice_02;
import java.util.*;

public class If03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("점수를 입력하시오");
        int score = scanner.nextInt();
        char grade;

        if(score>=90){
            grade = 'A';
        } else if(score>=80){
            grade = 'B';
        } else if(score>=70){
            grade = 'C';
        } else if(score>=60){
            grade = 'D';
        } else{
            grade = 'F';
        }
        System.out.println("학점은 "+grade+"입니다");
    }    
}
