package Iterator;

public class Main {
    public static void main(String[] args) {
        // Create a FibonacciSequence instance with a limit of 10
        FibonacciSequence fibonacciSequence = new FibonacciSequence(10);

        // Print the first 10 Fibonacci numbers
        System.out.println("First 10 Fibonacci numbers:");
        for (int num : fibonacciSequence) {
            System.out.print(num + " ");
        }
    }
}
