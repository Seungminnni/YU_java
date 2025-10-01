package Homework_04;

public class DiscountResult { // 할인 결과를 나타내는 클래스
    public final int fare; // 최종 요금
    public final int discountAmount; // 할인 금액
    public final String reason; // 할인 사유

    public DiscountResult(int fare, int discountAmount, String reason) { // 할인 결과 생성자
        this.fare = fare; // 최종 요금 설정
        this.discountAmount = discountAmount; // 할인 금액 설정
        this.reason = reason; // 할인 사유 설정
    }
}
