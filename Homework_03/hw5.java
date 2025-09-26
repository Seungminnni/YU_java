package Homework_03;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class hw5 {
    // 단순 카테고리 판정(버거, 사이드, 음료, 기타)
    private static String categoryOf(String menu) {
        if (menu.contains("버거")) return "burger";
        if (menu.contains("감자") || menu.contains("튀김") || menu.contains("사이드")) return "side";
        if (menu.contains("콜라") || menu.toLowerCase().contains("cola")) return "drink";
        return "other";
    }

    // 기본 파서
    public static void parse(String orderLine) {
        parse(orderLine, null);
    }

    // 별칭(alias) 적용 파서
    public static void parse(String orderLine, String[][] alias) {
        if (orderLine == null || orderLine.trim().isEmpty()) return;

        // 순서를 유지하는 맵(입력 순서 유지) - 메뉴명 -> 합계
        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        // 콤마로 분리
        String[] items = orderLine.split(",");
        for (String raw : items) {
            String item = raw.trim();
            if (item.isEmpty()) continue;

            // 'x'의 위치가 다양할 수 있으므로 소문자화해서 찾음
            int xPos = item.toLowerCase().indexOf('x');
            if (xPos == -1) continue; // 수량 표기가 없으면 무시

            String name = item.substring(0, xPos).trim();
            String qtyPart = item.substring(xPos + 1).trim();

            // qtyPart가 숫자가 아닐 수도 있으니 숫자만 취함
            StringBuilder digits = new StringBuilder();
            for (char c : qtyPart.toCharArray()) {
                if (Character.isDigit(c)) digits.append(c);
                else break;
            }
            if (digits.length() == 0) continue;
            int qty = Integer.parseInt(digits.toString());

            // 별칭 적용: alias는 { {별칭, 표준명}, ... }
            if (alias != null) {
                for (String[] pair : alias) {
                    if (pair.length >= 2 && pair[0].equals(name)) {
                        name = pair[1];
                        break;
                    }
                }
            }

            counts.put(name, counts.getOrDefault(name, 0) + qty);
        }

        // 카테고리별로 메뉴를 모아 출력순 결정
        Map<String, List<String>> byCat = new LinkedHashMap<>();
        byCat.put("burger", new ArrayList<>());
        byCat.put("side", new ArrayList<>());
        byCat.put("drink", new ArrayList<>());
        byCat.put("other", new ArrayList<>());

        for (String menu : counts.keySet()) {
            String cat = categoryOf(menu);
            byCat.get(cat).add(menu);
        }

        String[] order = {"burger", "side", "drink", "other"};
        for (String cat : order) {
            for (String menu : byCat.get(cat)) {
                System.out.println(menu + "=" + counts.get(menu));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // 예시 별칭: 제로콜라 -> 콜라ZERO
        String[][] alias = new String[][]{{"제로콜라", "콜라ZERO"}};
        parse(input, alias);
        scanner.close();
    }
}
