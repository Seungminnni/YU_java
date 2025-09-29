package Practice_07;

public class Animal {
    private static int count;
    String name;

    Animal(){
        Animal.count = Animal.count + 1;
        this.name = "이름없음";
    }
    Animal(String name){
        this();
        this.name = name;
    }
    public static void getCount()
    {
        System.out.println("동물의 수: "+Animal.count);
    }
    void Talk()
    {
        System.out.println(this.name+"이 말합니다.");

    }
    void Print()
    {
        System.out.println("생물정보");
        System.out.println("이름: "+this.name); 
    }
}

