package Homework_04;

import java.time.LocalDateTime;

public class RideContext { // 승차 상황을 나타내는 클래스
    public final LocalDateTime time; // 승차 시간
    public final String paymentMethod; // 결제 수단 (예: 카드, 현금)
    public final boolean partnerCard; // 제휴 카드 여부

    public RideContext(LocalDateTime time, String paymentMethod, boolean partnerCard) { // 승차 상황 생성자
        this.time = time;
        this.paymentMethod = paymentMethod;
        this.partnerCard = partnerCard;
    }
}
