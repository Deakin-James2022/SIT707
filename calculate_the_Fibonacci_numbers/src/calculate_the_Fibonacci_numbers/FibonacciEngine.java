package calculate_the_Fibonacci_numbers;

public class FibonacciEngine {
    public long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");// @throws IllegalArgumentException if n is negative
        }
        if (n == 0) {
            return 0;// @param n the index (must be >= 0)
        }
        if (n == 1) {
            return 1;
        }
        long previous = 0;
        long current = 1;
        for (int i = 2; i <= n; i++) {
            long next = previous + current;// Return the nth Fibonacci number
            previous = current;
            current = next;
        }
        return current;// @return the nth Fibonacci number
    }
}
