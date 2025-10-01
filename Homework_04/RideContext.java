package Homework_04;

import java.time.LocalDateTime;

public class RideContext {
    public final LocalDateTime time;
    public final String paymentMethod;
    public final boolean partnerCard;

    public RideContext(LocalDateTime time, String paymentMethod, boolean partnerCard) {
        this.time = time;
        this.paymentMethod = paymentMethod;
        this.partnerCard = partnerCard;
    }
}
