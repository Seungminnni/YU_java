package Homework_05;
public class NumberConverter {

    // 문자열을 정수로 변환
    public int stringToInt(String s) {
        return Integer.parseInt(s.trim());
    }

    // 정수를 이진수 문자열로 변환
    public String toBinary(int n) {
        return Integer.toBinaryString(n);
    }

    // 두 Integer 객체를 비교 (값이 같은지)
    public boolean compareNumbers(Integer a, Integer b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.equals(b);
    }

    // 실수(double)를 반올림하여 정수로 변환
    public int roundDouble(double d) {
        return (int) Math.round(d);
    }

    // 간단한 실행 예시를 main으로 포함하여 컴파일/실행 검증 가능하도록 함
    public static void main(String[] args) {
        NumberConverter converter = new NumberConverter();

        int num = converter.stringToInt("123");
        System.out.println("stringToInt(\"123\") => " + num);

        String binary = converter.toBinary(10);
        System.out.println("toBinary(10) => " + binary);

        boolean isSame = converter.compareNumbers(100, 100);
        System.out.println("compareNumbers(100, 100) => " + isSame);

        int rounded = converter.roundDouble(3.7);
        System.out.println("roundDouble(3.7) => " + rounded);
    }
}
