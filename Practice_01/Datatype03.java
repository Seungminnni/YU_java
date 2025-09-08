package Practice_01;

public class Datatype03 {
    public static void main(String[] args) {
        char c1 = 'J';
        char c2 = 'A'; 
        char c3 = 'V'; 
        char c4 = 'A';
        char c5 = '1';
        char c6 = '.';
        int x = 0;
        for (char i = '가'; i <= '힣'; i++) {
            x++;
            System.out.println(i);
            if(x%20 == 0) {
                {
                    System.out.println();
                }
            }
        }
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
    }
}
