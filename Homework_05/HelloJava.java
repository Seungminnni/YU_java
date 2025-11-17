package Homework_05;

import java.util.Scanner;

public class HelloJava {
	public static void main(String[] args) {
		String input = "";
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNextLine()) {
			input = scanner.nextLine(); // 한 줄씩 입력받기
		}

		int length = input.length(); // 문자열 길이

		String upper = input.toUpperCase(); // 대문자로 바꾸기

		String reversed = new StringBuilder(input).reverse().toString(); // 반전

		int aCount = 0; 
		for (int i = 0; i < input.length(); i++) { // 문자열 갯수만큼 반복
			char c = input.charAt(i); // 각 문자 추출
			if (c == 'a' || c == 'A') 
            aCount++; // a가 포함 되어있다면 갯수 증가
		}

		System.out.println("문자열 길이: " + length);
		System.out.println("대문자 변환: " + upper);
		System.out.println("역순 출력: " + reversed);
		System.out.println("'a'의 개수: " + aCount + "개");
		scanner.close();
	}
}
