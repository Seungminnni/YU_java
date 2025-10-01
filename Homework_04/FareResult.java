package Homework_04;

import java.util.ArrayList; 
import java.util.List;

public class FareResult { // 요금 계산 결과를 나타내는 클래스
    public final int rawFare; // 원래 요금
    public final List<String> steps = new ArrayList<>(); // 요금 계산 단계 배열
    public final int finalFare; // 최종 요금

    public FareResult(int rawFare, List<String> steps, int finalFare) { // 요금 계산 결과 생성자
        this.rawFare = rawFare; // 원래 요금 설정
        if (steps != null) this.steps.addAll(steps); // 단계 설정
        this.finalFare = finalFare; // 최종 요금 설정
    }
}
