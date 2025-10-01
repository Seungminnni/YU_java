package Homework_04;

public class UniversityPartnerDiscount implements DiscountPolicy {
    private final double rate; // e.g., 0.9 for 10% off

    public UniversityPartnerDiscount(double rate) {
        this.rate = rate;
    }

    @Override
    public int apply(int currentFare, Transport t, int distanceKm, int transfersToday) {
        int nf = (int) Math.round(currentFare * rate);
        return Math.max(0, nf);
    }
}
