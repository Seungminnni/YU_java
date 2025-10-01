package Homework_04;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Transport_fee { // 최종 실행 클래스
    public static void main(String[] args) { // 메인 메서드 시작
        Transport bus = new Bus(); // 버스 교통수단 객체 생성
        Transport subway = new Subway(); // 지하철 교통수단 객체 생성
        Transport express = new ExpressBus(); // 고속버스 교통수단 객체 생성

        TransitCard adultGeneral = new AdultCard("A1"); // 일반 성인 교통카드 객체 생성
        TransitCard adultUniversity = new AdultCard("A2"); // 대학생 성인 교통카드 객체 생성
        TransitCard teen = new TeenCard("T1"); // 청소년 교통카드 객체 생성
        TransitCard senior = new SeniorCard("S1"); // 노인 교통카드 객체 생성

        teen.addPolicy(new TransferDiscount(200)); // 환승할인 200원
        adultGeneral.addPolicy(new TransferDiscount(200)); // 환승할인 200원
        adultUniversity.addPolicy(new TransferDiscount(200)); // 환승할인 200원
        adultUniversity.addPolicy(new UniversityPartnerDiscount(0.9)); // 대학생 할인 10%

        FareCalculator calc = new FareCalculator(); // 요금 계산기 객체 생성


        // 모든 조건은 같은 것으로 가정하고 카드에 따른 할인만 적용 
        // 환승은 0회, 거리는 기본으로 가정
        System.out.println("\n[지하철 기준] 같은 거리, 다른 카드 따른 할인만 적용, 환승은 0회 거리는 기본으로 가정");
        List<TransitCard> cards = Arrays.asList(adultGeneral, adultUniversity, teen, senior); // 다양한 교통카드 배열리스트 생성, 어른, 대학생제휴, 청소년, 노인
        RideContext ctxSame = new RideContext(LocalDateTime.of(2025,9,26,10,0), "card", false);
        int sameDistance = 0;
        int sameTransfers = 0;
        for (TransitCard c : cards) {
            FareResult rr = calc.calculate(c, subway, sameDistance, sameTransfers, ctxSame);
            String cardName = (c == adultGeneral) ? "일반 성인" : (c == adultUniversity) ? "대학생 제휴" : (c == teen) ? "청소년" : (c == senior) ? "노인" : c.getClass().getSimpleName();
            System.out.println("카드이름=" + cardName + ", 할인과정=" + rr.steps + " 최종요금=" + rr.finalFare );
        }

        
        System.out.println("\n어른카드 기준 다른 교통수단을 확인하기 위해 가정 거리는 20키로 환승은 2회로 가정");
        List<Transport> transports = Arrays.asList(subway, bus, express);
        TransitCard demoCard = adultGeneral; // use general adult card for comparison
        RideContext ctxSame2 = new RideContext(LocalDateTime.of(2025,9,26,10,0), "card", false);
        int d = 20;
        int t = 2;
        for (Transport tr : transports) {
            FareResult rr = calc.calculate(demoCard, tr, d, t, ctxSame2);
            System.out.println("교통수단=" + tr.getClass().getSimpleName() + ", 할인과정=" + rr.steps + " 최종요금=" + rr.finalFare);
        }
    }
}
