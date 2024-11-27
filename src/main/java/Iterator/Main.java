package Iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Create a FibonacciSequence instance
        FibonacciSequence fibonacciSequence = new FibonacciSequence();

        Iterator<Integer> iterator = new FibonacciIterator(10);

        // Print the first 10 Fibonacci numbers
        System.out.println("First 10 Fibonacci numbers:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
