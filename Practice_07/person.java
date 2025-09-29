package Practice_07;

public class person{
    String name;
    private static int reg_num;
    person()
    {
        this.name="이름없음";
        person.reg_num = person.reg_num + 1;
        System.out.println("사용자"+person.reg_num+"등록된 이름: "+this.name);
        
    }
    person(String name)
    {
        this.name=name;
        person.reg_num = person.reg_num + 1;
        System.out.println("사용자"+person.reg_num+"등록된 이름: "+this.name);
    }
    
    void walk(){
        System.out.println(this.name+"이(가) 걷습니다."); // 클래스 내부의 변수를 사용하려면 this를 사용
    }
    void run(){

    }
}
