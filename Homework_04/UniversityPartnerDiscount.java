package Homework_04;

public class UniversityPartnerDiscount implements DiscountPolicy { // 대학 제휴 할인을 위한 클래스이며, DiscountPolicy 인터페이스를 구현
    private final double rate; // 할인율 고정

    public UniversityPartnerDiscount(double rate) { // 대학 제휴 할인을 구현하는 생성자
        this.rate = rate; // 할인율을 설정
    }

    @Override
    public int apply(int currentFare, Transport t, int distanceKm, int transfersToday) { // 대학 제휴 할인을 적용하는 메서드
        int nf = (int) Math.round(currentFare * rate); // 현재 요금에 할인율을 곱하고 반올림하여 새로운 요금을 계산
        return Math.max(0, nf); // 새로운 요금이 0보다 작아지지 않도록 함
    }
}
