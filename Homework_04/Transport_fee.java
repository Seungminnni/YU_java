package Homework_04;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Transport_fee {
    public static void main(String[] args) {
        Transport bus = new Bus();
        Transport subway = new Subway();
        Transport express = new ExpressBus();

        TransitCard adult = new AdultCard("A1");
        TransitCard teen = new TeenCard("T1");
        TransitCard senior = new SeniorCard("S1");

        // add policies
        teen.addPolicy(new TransferDiscount(200)); // 환승할인 200원
        adult.addPolicy(new TransferDiscount(200)); // 환승할인 200원
        // university partner discount for adult (simulate partner)
        adult.addPolicy(new UniversityPartnerDiscount(0.9)); // 대학생 할인 10%

        FareCalculator calc = new FareCalculator();

        // --- existing individual demos ---


        // --- New: demonstrate List<TransitCard> with same ride parameters ---
        System.out.println("\nDemo: same ride, different cards:");
        List<TransitCard> cards = Arrays.asList(adult, teen, senior);
        RideContext ctxSame = new RideContext(LocalDateTime.of(2025,9,26,10,0), "card", false);
        int sameDistance = 12;
        int sameTransfers = 1;
        for (TransitCard c : cards) {
            FareResult rr = calc.calculate(c, subway, sameDistance, sameTransfers, ctxSame);
            System.out.println("Card=" + c.getClass().getSimpleName() + " finalFare=" + rr.finalFare + " steps=" + rr.steps);
        }

        // --- New: demonstrate List<Transport> with same ride parameters ---
        System.out.println("\nDemo: same card, same distance/transfers, different transports:");
        List<Transport> transports = Arrays.asList(subway, bus, express);
        TransitCard demoCard = adult; // use adult card for comparison
        RideContext ctxSame2 = new RideContext(LocalDateTime.of(2025,9,26,10,0), "card", false);
        int d = 12;
        int t = 1;
        for (Transport tr : transports) {
            FareResult rr = calc.calculate(demoCard, tr, d, t, ctxSame2);
            System.out.println("Transport=" + tr.getClass().getSimpleName() + " finalFare=" + rr.finalFare + " steps=" + rr.steps);
        }
    }
}
