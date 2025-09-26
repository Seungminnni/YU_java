package Homework_03;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class hw_4 {
    public static String normalize(String name) {
        return normalize(name, false);
    }

    public static String normalize(String name, boolean keepSuffix) {
        if (name == null) return null;
        // 괄호 제거
        int parenStart = name.indexOf('(');
        if (parenStart != -1) {
            name = name.substring(0, parenStart);
        }
        // "역" 제거, keepSuffix가 false면
        if (!keepSuffix && name.endsWith("역")) {
            name = name.substring(0, name.length() - 1);
        }
        return name.trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        Set<String> normalized = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            String name = scanner.nextLine();
            String norm = normalize(name);
            normalized.add(norm);
        }
        for (String s : normalized) {
            System.out.println(s);
        }
        scanner.close();
    }
}