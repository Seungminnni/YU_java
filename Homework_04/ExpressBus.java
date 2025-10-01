package Homework_04;

public class ExpressBus extends Transport { // 이동수단의 추상클래스를 상속받는 고속버스 클래스
    public ExpressBus() {
        super("ExpressBus", 2000, 80); // 기본요금 2000원, 거리당 요금 80원/km
    }
}
