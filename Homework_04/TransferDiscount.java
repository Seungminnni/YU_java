package Homework_04;

public class TransferDiscount implements DiscountPolicy {
    private final int discountAmount; // 고정 할인

    public TransferDiscount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public int apply(int currentFare, Transport t, int distanceKm, int transfersToday) {
        if (transfersToday > 0) {
            return Math.max(0, currentFare - discountAmount);
        }
        return currentFare;
    }
}
