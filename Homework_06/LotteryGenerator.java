package Homework_06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class LotteryGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 로또 번호 생성기 ===");
        System.out.print("몇 게임을 생성하시겠습니까? ");
        String line = scanner.nextLine().trim();

        int games = 0;
        try {
            games = Integer.parseInt(line);
            if (games <= 0) {
                System.out.println("1 이상의 정수를 입력하세요.");
                scanner.close();
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("유효한 숫자를 입력하세요.");
            scanner.close();
            return;
        }

        Random rand = new Random();

        for (int g = 1; g <= games; g++) {
            HashSet<Integer> set = new HashSet<>();

            while (set.size() < 6) {
                int n = rand.nextInt(45) + 1; // 1..45
                set.add(n); // HashSet으로 중복 방지
            }

            ArrayList<Integer> list = new ArrayList<>(set);
            Collections.sort(list);

            System.out.print("[" + g + "게임] ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i < list.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
