package Homework_04;

import java.util.List;

public class SeniorCard extends TransitCard { // 교통카드 클래스를 상속받은 노인 교통카드 클래스를 정의
    public SeniorCard(String ownerId) { super(ownerId, "Senior"); } // 이 생성자는 노인이라는 ID를 호출

    @Override
    protected int applyCardDiscount(int current, Transport t, int distanceKm, int transfersToday, RideContext ctx, List<String> steps) { // 부모 클래스의 매서드를 오버라이드하여 노인 카드 할인에 대해 재정의
        int discounted = (int) Math.round(current * 0.5); // 50프로 할인
        steps.add("senior 50% -> " + discounted); // 할인된 내역을 단계에 추가
        return discounted; // 할인된 요금을 반환
    }
}
