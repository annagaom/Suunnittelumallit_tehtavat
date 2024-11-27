package Iterator;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int previous = 1; // F(n-2), initialized to 1
    private int current = 1;  // F(n-1), initialized to 1
    private int count = 0;    // Tracks the current position in the sequence
    private int limit;        // Optional limit for finite iteration

    // Constructor for an unlimited Fibonacci sequence
    public FibonacciIterator() {
        this.limit = -1; // Negative limit indicates no stopping condition
    }

    // Constructor for a limited Fibonacci sequence
    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return limit < 0 || count < limit;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements in the Fibonacci sequence");
        }
        count++;

        // Return the first Fibonacci number
        if (count == 1) {
            return 1;
        }

        // Return the second Fibonacci number
        if (count == 2) {
            return 1;
        }

        // Calculate the next Fibonacci number
        int next = previous + current; // F(n) = F(n-2) + F(n-1)
        previous = current;
        current = next;

        return next;
    }
}
