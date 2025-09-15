package Practice_02;

public class practice1 {
    public static void main(String[] args) {
        
        int i, j;

        for (i=0; i<10; i++){
            for (j=0; j<10; j++){
                System.out.println("current i: " + i + ", current j: " + j);
            
            if (j == 5) {
                break;
            }

            }
        }
    }
}
