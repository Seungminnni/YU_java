package Practice_02;

public class Break01 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break; // i가 5일 때 반복문 종료
            }
            System.out.println("Current i: " + i);
        }
    }
}
