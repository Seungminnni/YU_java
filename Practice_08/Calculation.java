package Practice_08;

public class Calculation {
    int z;

    public void addition(int x, int y) {
        z = x + y;
        System.out.println("덧셈: " + z);
    }
    public void subtraction(int x, int y) {
        z = x - y;
        System.out.println("뺄셈: " + z);
    }

    public class Inheritance extends Calculation {
        public void multiplication(int x, int y) {
            z = x * y;
            System.out.println("곱셈: " + z);
        }

    }
    public static void main(String[] args) {
        Calculation calc = new Calculation();
        calc.addition(5, 3);
        calc.subtraction(5, 3);

        Inheritance inherit = calc.new Inheritance();
        inherit.multiplication(5, 3);
    }
    
}
