package Practice_02;

import java.util.*;

public class practice2 {

	public static void main(String[] args) {
		// 데이터를 입력받기 위한 부분
		Scanner input = new Scanner(System.in);
		double sum = 0.0;
		// 우선, 무조건 입력 받는 데이터는 문자열로 받는다고 가정한다
		String str = input.nextLine();
		String[] strs = str.split(" "); // 띄워쓰기로 구분해서 문자열
		// 배열을 입력받음

		for ( int i = 0 ; i < strs.length ; i++ )
		{
			// 검사절
			boolean hasChar = false; // 문자가 발견될 경우? 
			boolean hasDot = false; // .이 포함될 겨우?
			for ( int j = 0 ; j < strs[i].length() ; j++)
			{
				char c = strs[i].charAt(j);
				if ( c == '.') // .이 있을 경우 -> 실수 의심
				{
					hasDot = true;
				}
				else if ( c < '0' || c > '9')
				{
					// 숫자 범위를 벗어날 경우 -> 문자임
						hasChar = true;
						break;
				}							
			}
			if ( hasChar == false )
			{
				if ( hasDot == true )
				{
					sum = sum + Double.parseDouble(strs[i]);
				}

				else
				{
					sum = sum + Integer.parseInt(strs[i]);
				}
			}
		}
		System.out.println("숫자 요소의 합: " + sum);

	}

}

