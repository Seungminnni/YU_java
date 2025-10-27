package Practice_09;

public abstract class Shape {
    String color;

    abstract double area();
    public abstract double String toString();

    public Shape(String color) {
        System.out.println("Shape 생성자 호출");
        this.color = color;
    }
    public String gerColor(){
        return color;
    }
    
}
