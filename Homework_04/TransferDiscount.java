package Homework_04;

public class TransferDiscount implements DiscountPolicy { // 환승할인을 위한 클래스이며, DiscountPolicy 인터페이스를 구현
    private final int discountAmount; // 고정 할인

    public TransferDiscount(int discountAmount) { // 환승 할인을 구현하는 생성자
        this.discountAmount = discountAmount; // 할인 금액을 설정
    }

    @Override
    public int apply(int currentFare, Transport t, int distanceKm, int transfersToday) { // 환승 할인을 적용하는 메서드
        if (transfersToday > 0) { // 환승 횟수가 0보다 크면 (즉, 환승이 발생한 경우)
            return Math.max(0, currentFare - discountAmount); // 현재 요금에서 할인 금액을 빼고, 0보다 작아지지 않도록 함
        }
        return currentFare; // 환승이 없으면 현재 요금을 그대로 반환
    }
}
