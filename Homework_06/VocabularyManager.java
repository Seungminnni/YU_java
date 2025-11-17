package Homework_06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class VocabularyManager {

    private static final Path VOCAB_FILE = Paths.get("vocabulary.txt");

    public static void main(String[] args) {
        TreeMap<String, String> vocab = new TreeMap<>();
        // 1) Load from file
        int loaded = loadFromFile(vocab);
        System.out.println("=== 단어장 프로그램 ===");
        System.out.println("vocabulary.txt에서 " + loaded + "개 단어를 불러왔습니다.");

        try (Scanner sc = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println();
                System.out.println("1. 단어 추가");
                System.out.println("2. 단어 검색");
                System.out.println("3. 단어 목록");
                System.out.println("4. 단어 테스트");
                System.out.println("5. 저장 및 종료");
                System.out.print("선택: ");

                String choice = sc.nextLine().trim();
                switch (choice) {
                    case "1": // 추가
                        System.out.print("영어 단어: ");
                        String eng = sc.nextLine().trim();
                        if (eng.isEmpty()) {
                            System.out.println("단어를 입력하세요.");
                            break;
                        }
                        System.out.print("한글 뜻: ");
                        String kor = sc.nextLine().trim();
                        if (kor.isEmpty()) {
                            System.out.println("뜻을 입력하세요.");
                            break;
                        }
                        if (vocab.containsKey(eng)) {
                            System.out.print("이미 등록된 단어입니다. 덮어쓸까요? (y/n): ");
                            String yn = sc.nextLine().trim();
                            if (!yn.equalsIgnoreCase("y")) {
                                System.out.println("추가 취소");
                                break;
                            }
                        }
                        vocab.put(eng, kor);
                        System.out.println("[추가 완료]");
                        break;

                    case "2": // 검색
                        System.out.print("검색할 단어: ");
                        String key = sc.nextLine().trim();
                        if (vocab.containsKey(key)) {
                            System.out.println("결과: " + key + " - " + vocab.get(key));
                        } else {
                            System.out.println("결과가 없습니다: " + key);
                        }
                        break;

                    case "3": // 목록
                        System.out.println("[단어 목록]");
                        if (vocab.isEmpty()) {
                            System.out.println("(등록된 단어가 없습니다)");
                        } else {
                            for (Map.Entry<String, String> e : vocab.entrySet()) {
                                System.out.println(e.getKey() + ": " + e.getValue());
                            }
                        }
                        break;

                    case "4": // 테스트
                        doTest(sc, vocab);
                        break;

                    case "5": // 저장 및 종료
                        int saved = saveToFile(vocab);
                        System.out.println("vocabulary.txt에 " + saved + "개 단어를 저장했습니다.");
                        running = false;
                        break;

                    default:
                        System.out.println("올바른 선택이 아닙니다. 1~5 중 선택하세요.");
                }
            }
        }
    }

    private static int loadFromFile(TreeMap<String, String> vocab) {
        if (!Files.exists(VOCAB_FILE)) {
            // create empty file
            try {
                Files.write(VOCAB_FILE, new ArrayList<>(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                // ignore
            }
            return 0;
        }

        try {
            List<String> lines = Files.readAllLines(VOCAB_FILE, StandardCharsets.UTF_8);
            int count = 0;
            for (String raw : lines) {
                String line = raw.trim();
                if (line.isEmpty()) continue;
                int idx = line.indexOf(':');
                if (idx <= 0) continue; // skip malformed
                String eng = line.substring(0, idx).trim();
                String kor = line.substring(idx + 1).trim();
                if (!eng.isEmpty() && !kor.isEmpty()) {
                    vocab.put(eng, kor);
                    count++;
                }
            }
            return count;
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            return 0;
        }
    }

    private static int saveToFile(TreeMap<String, String> vocab) {
        List<String> out = new ArrayList<>();
        for (Map.Entry<String, String> e : vocab.entrySet()) {
            out.add(e.getKey() + ":" + e.getValue());
        }
        try {
            Files.write(VOCAB_FILE, out, StandardCharsets.UTF_8);
            return out.size();
        } catch (IOException ex) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + ex.getMessage());
            return 0;
        }
    }

    private static void doTest(Scanner sc, TreeMap<String, String> vocab) {
        if (vocab.isEmpty()) {
            System.out.println("단어가 없습니다. 먼저 단어를 추가하세요.");
            return;
        }
        List<String> keys = new ArrayList<>(vocab.keySet());
        Collections.shuffle(keys, new Random());
        int total = Math.min(5, keys.size());
        System.out.println("[단어 테스트 - " + total + "문제]");
        int correct = 0;
        for (int i = 0; i < total; i++) {
            String eng = keys.get(i);
            System.out.print((i + 1) + ") " + eng + "의 뜻은? ");
            String answer = sc.nextLine().trim();
            String expected = vocab.get(eng).trim();
            if (answer.equals(expected)) {
                System.out.println("정답!");
                correct++;
            } else {
                System.out.println("오답! 정답: " + expected);
            }
        }
        double pct = 100.0 * correct / total;
        System.out.printf("결과: %d문제 중 %d문제 정답 (%.1f%%)%n", total, correct, pct);
    }
}
