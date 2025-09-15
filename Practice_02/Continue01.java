package Practice_02;

public class Continue01 {
    public static void main(String[] args) {
        for (int i = 1; i < 4; i++) {
            for(int j = 1; j <= 3; j++) {
                if (j == 3 && i == 2) {
                    continue; // j가 3이고 i가 2일 때 현재 반복을 건너뜀
                }

            System.out.println(i+"*" +j);
        }
    }
    
}
}