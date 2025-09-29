package Practice_07;

public class person_1{
    String name;
    private int age;
    private static int reg_num;
    person_1()
    {
        this.name="이름없음";
        this.age = -1;
        person_1.reg_num = person_1.reg_num + 1;
      

    }
    person_1(String name)
    { this();
        this.name=name;
    }
    person_1(int age){
        this();
        this.age = age;
    }
    void walk(){
        System.out.println(this.name+"이(가) 걷습니다."); // 클래스 내부의 변수를 사용하려면 this를 사용
    }
    void run(){

    }
}
