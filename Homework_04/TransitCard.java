package Homework_04;

import java.util.ArrayList; // 배열 리스트 임포트
import java.util.List; // 리스트 임포트

public abstract class TransitCard {// 교통카드 추상클래스
    protected final String ownerId; // 소유자 ID
    protected final String ownerType; // 소유자 유형
    protected final List<DiscountPolicy> policies = new ArrayList<>(); // 할인 정책 리스트

    protected TransitCard(String ownerId, String ownerType) { // 교통카드 생성자
        this.ownerId = ownerId; // 소유자 ID는 소유자 ID
        this.ownerType = ownerType; // 소유자 유형은 소유자 유형
    }

    public String getOwnerType() { // 소유자 유형을 불러오는 매서드
        return ownerType; // 소유자 유형 반환
    } 

    public void addPolicy(DiscountPolicy p) { // 할인 정책 추가 매서드
         if (p != null) policies.add(p);  // 만약 p값이 널이 아닐떄 p의 정책을 리스트에 추가
        }

    public FareResult calculateFare(Transport t, int distanceKm, int transfersToday, RideContext ctx) { // 요금 계산결과로 반환하는 요금 계산 매서드
        List<String> steps = new ArrayList<>(); // 새로운 단계 리스트 작성
        int raw = t.computeDistanceFare(distanceKm); // 기본 거리 요금 계산
        int current = raw; // 현재는 기본 거리 요금
        steps.add("distanceFare=" + raw); // 요금 단계에 기본 거리 요금 추가

        current = applyCardDiscount(current, t, distanceKm, transfersToday, ctx, steps); // 카드 할인 적용해서 현재 요금 갱신

        for (DiscountPolicy p : policies) { // 각 정책에 대해 반복, 할인 적용을 위한 반복문, 각 할인 조건에 대해 반복을 하며 그에 대해 현재요금과 다르다면 그것을 적용
            int nf = p.apply(current, t, distanceKm, transfersToday); // nf는 정책 적용 후 요금
            if (nf != current) { // 만약 nf가 현재 요금과 다르다면
                steps.add(p.getDescription(current, t, distanceKm, transfersToday) + " -> " + nf); // 상세 설명 추가
                current = nf; // 현재 요금을 nf로 갱신
            }
        }

        int finalFare = Math.max(0, current); // 최종 요금은 0원 미만이 될 수 없으므로 0과 현재 요금 중 큰 값
        return new FareResult(raw, steps, finalFare); // 요금 결과 반환
    }

    protected int applyCardDiscount(int current, Transport t, int distanceKm, int transfersToday, RideContext ctx, List<String> steps) { // 다양한 카드 할인을 적용하는 매서드
        return current; // 현재를 돌려주는 이유는 카드마다 다른 매커니즘이 적용되어있기 때문에 단지 인자를 받아 현재의 값으로 리턴해주는 것임.
    }
}
