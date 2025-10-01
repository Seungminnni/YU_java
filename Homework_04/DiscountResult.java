package Homework_04;

public class DiscountResult {
    public final int fare;
    public final int discountAmount;
    public final String reason;

    public DiscountResult(int fare, int discountAmount, String reason) {
        this.fare = fare;
        this.discountAmount = discountAmount;
        this.reason = reason;
    }
}
