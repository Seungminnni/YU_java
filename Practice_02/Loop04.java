package Practice_02;

import java.util.*;

public class Loop04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int buffer = Integer.parseInt(in.next());
        int i, j;
        for(i = 0; i < buffer; i++) {
            for(int k = buffer - i - 1; k > 0; k--) {
                System.out.print(" ");
            }
            for(j = 0; j < (i*2)+1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

    }

    
}
