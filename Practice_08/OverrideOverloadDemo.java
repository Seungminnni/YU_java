package Practice_08;

// Demonstrates method overloading (same method name, different parameters)
// and method overriding (subclass replaces superclass implementation)
public class OverrideOverloadDemo {

    static class Animal {
        String name;
        Animal(String name) { this.name = name; }

        // method to be overridden
        public void speak() {
            System.out.println(name + " says: ...");
        }

        // overloaded method: same name, different parameters
        public void move() {
            System.out.println(name + " moves a little.");
        }

        public void move(int steps) {
            System.out.println(name + " moves " + steps + " steps.");
        }
    }
// 여기까지는 애니멀 클래스 선언

    static class Dog extends Animal { // 개 클래스는 동물 클래스 상속받음
        Dog(String name) { super(name); } // 개 이름은 부모 생성자 호출

        // override speak()
        @Override // 부모의 speak() 메서드를 재정의
        public void speak() {
            System.out.println(name + " says: 멍멍!");
        }

        // 오버로드 
        public void speak(String mood) {
            System.out.println(name + " says: " + (mood.equals("happy") ? "왈왈!" : "으르렁"));
        }
    }

    public static void main(String[] args) {
        Animal a = new Animal("동물");
        a.speak();          // Animal.speak
        a.move();           // Animal.move()
        a.move(3);          // Animal.move(int)

        System.out.println("---");

        Animal d = new Dog("해피");
        d.speak();          // Dog.speak() -> overriding
        d.move();           // Animal.move() (inherited)
        d.move(5);          // Animal.move(int)

        // To access overloaded speak in Dog, need Dog reference
        Dog realDog = (Dog) d;
        realDog.speak("happy"); // overloaded speak in Dog
    }
}
