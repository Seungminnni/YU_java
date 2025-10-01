package Homework_04;

import java.util.List;

public class TeenCard extends TransitCard { // 교통카드 클래스를 상속받은 학생 교통카드 클래스를 정의
    public TeenCard(String ownerId) { super(ownerId, "Teen"); } // 이 생성자는 학생이라는 ID를 호출

    @Override // 오버라이드
    protected int applyCardDiscount(int current, Transport t, int distanceKm, int transfersToday, RideContext ctx, List<String> steps) { // 부모 클래스의 매서드를 오버라이드하여 학생 카드 할인에 대해 재정의
        int discounted = (int) Math.round(current * 0.8); // 20프로 할인
        steps.add("teen 20% -> " + discounted); // 할인된 내역을 단계에 추가
        return discounted; // 할인된 요금을 반환
    }
}
