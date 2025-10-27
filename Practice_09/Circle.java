package Practice_09;

public class Circle extends Shape {
    double radius;

    public Circle(String color, double radius) {
        super(color);
        System.out.println("Circle 생성자 호출");
        this.radius = radius;
    }

    @Override
    double area() {
        return 3.14 * radius * radius;
    }

    @Override
    public String toString() {
        return "원 색상은 " + getColor() + "이고, 넓이는 " + area() + "입니다.";
    }
    
}
