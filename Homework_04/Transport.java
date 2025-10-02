package Homework_04;

public abstract class Transport { // 추상 클래스
    protected final String name; // 이름
    protected final int baseFare; // 기본 요금, 원단위,
    protected final int perKmFare; // 거리당 요금, 원/km ''

    protected Transport(String name, int baseFare, int perKmFare) { // 이동수단 생성자
        this.name = name; // 이름은 이름
        this.baseFare = baseFare; // 기본 요금은 기본 요금
        this.perKmFare = perKmFare; // 거리당 요금은 거리당 요금
    }

    public int getBaseFare() { // 기본 요금을 불러오는 매서드
        return baseFare; // 기본 요금 반환
    }

    public int getPerKmFare() { // 거리당 요금을 불러오는 매서드
        return perKmFare; // 거리당 요금 반환
    }

    public int computeDistanceFare(int distanceKm) { // 거리를 인자로 받는 거리당 요금을 계산하는 매서드
        if (distanceKm <= 0) { // 만약 거리가 0키로미터 == 기본요금 세팅
            return baseFare; // 거리가 0키로미터일때 기본요금 반환
        } else { // 그 외
            return baseFare + perKmFare * distanceKm; // 그 외에는 기본요금 + 거리당 요금 * 거리
        }
    }
}
