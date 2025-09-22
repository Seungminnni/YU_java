package Homework_03;

public class hw2 {
    public static int countFields(String line) {
        return countFields(line, ',');
    }
    
    public static int countFields(String line, char delim) {
        if (line == null || line.isEmpty()) {
            return 0;
        }
        return line.split(String.valueOf(delim), -1).length;
    }
    
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();
        int count = countFields(input);
        System.out.println("Fields=" + count);
        scanner.close();
    }
}