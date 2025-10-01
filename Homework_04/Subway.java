package Homework_04;

public class Subway extends Transport { // 이동수단의 추상클래스를 상속받는 지하철 클래스
    public Subway() {
        super("Subway", 1300, 40); // 기본요금 1300원, 거리당 요금 40원/km
    }
}
