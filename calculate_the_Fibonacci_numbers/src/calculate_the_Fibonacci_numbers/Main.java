package calculate_the_Fibonacci_numbers;

public class Main {
    public static void main(String[] args) {
        FibonacciEngine engine = new FibonacciEngine();
        for (int i = 0; i <= 10; i++) {
            System.out.println("F(" + i + ") = " + engine.fibonacci(i));
        }
    }
}
