package Homework_04;

public interface DiscountPolicy { // 할인 정책 인터페이스
    int apply(int currentFare, Transport t, int distanceKm, int transfersToday); // 현재 요금에 할인을 적용하고 새로운 요금을 반환
}
