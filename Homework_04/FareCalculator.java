package Homework_04;

public class FareCalculator {
    public FareResult calculate(TransitCard card, Transport t, int distanceKm, int transfersToday, RideContext ctx) { // 요금 계산 매서드
        return card.calculateFare(t, distanceKm, transfersToday, ctx); // 교통카드의 요금 계산 매서드를 호출하여 결과 반환
    }
}
