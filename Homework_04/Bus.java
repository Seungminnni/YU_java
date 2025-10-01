package Homework_04;

public class Bus extends Transport { // 이동수단의 추상클래스를 상속받는 버스 클래스
    public Bus() {
        super("Bus", 1200, 50); // 기본요금 1200원, 거리당 요금 50원/km
    }
}
