package Homework_06;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class InventoryManager {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            TreeMap<String, Integer> stock = new TreeMap<>();

            boolean running = true;
            while (running) {
                System.out.println("=== 재고 관리 시스템 ===");
                System.out.println("1. 상품 추가");
                System.out.println("2. 재고 증가");
                System.out.println("3. 재고 감소");
                System.out.println("4. 재고 조회");
                System.out.println("5. 전체 목록");
                System.out.println("6. 종료");
                System.out.print("선택: ");

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1": // 상품 추가
                        System.out.print("상품명: ");
                        String nameAdd = scanner.nextLine().trim();
                        if (nameAdd.isEmpty()) {
                            System.out.println("상품명을 입력하세요.");
                            break;
                        }
                        System.out.print("수량: ");
                        String qAddStr = scanner.nextLine().trim();
                        try {
                            int qty = Integer.parseInt(qAddStr);
                            if (qty < 0) {
                                System.out.println("수량은 0 이상의 정수여야 합니다.");
                                break;
                            }
                            if (stock.containsKey(nameAdd)) {
                                System.out.println("이미 등록된 상품입니다. 현재 재고: " + stock.get(nameAdd) + "개");
                            } else {
                                stock.put(nameAdd, qty);
                                System.out.println("[등록 완료]");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("유효한 수량을 입력하세요.");
                        }
                        break;

                    case "2": // 재고 증가
                        System.out.print("상품명: ");
                        String nameInc = scanner.nextLine().trim();
                        if (!stock.containsKey(nameInc)) {
                            System.out.println("등록되지 않은 상품입니다.");
                            break;
                        }
                        System.out.print("증가 수량: ");
                        String incStr = scanner.nextLine().trim();
                        try {
                            int inc = Integer.parseInt(incStr);
                            if (inc <= 0) {
                                System.out.println("증가 수량은 1 이상의 정수여야 합니다.");
                                break;
                            }
                            int newQty = stock.get(nameInc) + inc;
                            stock.put(nameInc, newQty);
                            System.out.println("[처리 완료] " + nameInc + " 재고: " + newQty + "개");
                        } catch (NumberFormatException e) {
                            System.out.println("유효한 수량을 입력하세요.");
                        }
                        break;

                    case "3": // 재고 감소
                        System.out.print("상품명: ");
                        String nameDec = scanner.nextLine().trim();
                        if (!stock.containsKey(nameDec)) {
                            System.out.println("등록되지 않은 상품입니다.");
                            break;
                        }
                        System.out.print("감소 수량: ");
                        String decStr = scanner.nextLine().trim();
                        try {
                            int dec = Integer.parseInt(decStr);
                            if (dec <= 0) {
                                System.out.println("감소 수량은 1 이상의 정수여야 합니다.");
                                break;
                            }
                            int newQty = stock.get(nameDec) - dec;
                            if (newQty <= 0) {
                                stock.put(nameDec, 0);
                                System.out.println("[처리 완료] " + nameDec + " 재고: 0개");
                                System.out.println("[품절] " + nameDec + "은(는) 품절되었습니다.");
                            } else {
                                stock.put(nameDec, newQty);
                                System.out.println("[처리 완료] " + nameDec + " 재고: " + newQty + "개");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("유효한 수량을 입력하세요.");
                        }
                        break;

                    case "4": // 재고 조회
                        System.out.print("상품명: ");
                        String nameQry = scanner.nextLine().trim();
                        if (!stock.containsKey(nameQry)) {
                            System.out.println("등록되지 않은 상품입니다.");
                        } else {
                            System.out.println(nameQry + ": " + stock.get(nameQry) + "개");
                        }
                        break;

                    case "5": // 전체 목록
                        System.out.println("[전체 재고 현황]");
                        if (stock.isEmpty()) {
                            System.out.println("등록된 상품이 없습니다.");
                        } else {
                            for (Map.Entry<String, Integer> e : stock.entrySet()) {
                                System.out.println(e.getKey() + ": " + e.getValue() + "개");
                            }
                        }
                        break;

                    case "6":
                        System.out.println("프로그램을 종료합니다.");
                        running = false;
                        break;

                    default:
                        System.out.println("올바른 선택이 아닙니다. 1~6 중 선택하세요.");
                }

                System.out.println();
            }
        }
    }
}
