package Practice_07;

public class Hello {
    public static void main(String[] args) {
        Human a = new Human("아Q");
        Cat c = new Cat(523);

        a.addMoney();
    }
    public static void talking(Animal a)
    {
        a.Talk();
        a.Print();
    }
    
}
