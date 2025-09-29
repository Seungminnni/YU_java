package Practice_07;

public class Human extends Animal{
    private int money;

    Human(String name){
        super(name);
        this.money = 0;
    }
    void Talk()
    {
        System.out.println(this.name+"이 말합니다.");

    }
    void Print()
    {
        System.out.println("생물정보");
        System.out.println("이름: "+this.name); 
        System.out.println("재산: "+this.money);
    }
    void addMoney()
    {
        this.money = this.money + 1000;
    }
}
