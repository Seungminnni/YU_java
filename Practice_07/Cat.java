package Practice_07;

public class Cat extends Animal {
    private int color;

    Cat(int color){
        super();
        this.color = color;
    }
    void Talk()
    {
        System.out.println(this.name+"이 야옹하고 웁니다.");

    }
    void Print()
    {
        System.out.println("생물정보");
        System.out.println("이름: "+this.name); 
        System.out.println("색깔: "+this.color);
    
    }
}
