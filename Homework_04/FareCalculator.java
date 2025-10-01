package Homework_04;

public class FareCalculator {
    public FareResult calculate(TransitCard card, Transport t, int distanceKm, int transfersToday, RideContext ctx) {
        return card.calculateFare(t, distanceKm, transfersToday, ctx);
    }
}
