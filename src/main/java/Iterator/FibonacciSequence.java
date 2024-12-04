package Iterator;

import java.util.Iterator;

//public class FibonacciSequence implements Sequence {
//
//    @Override
//    public Iterator<Integer> iterator() {
//
//        return new FibonacciIterator();
//    }
//
//}


public class FibonacciSequence implements Iterable<Integer> {

    private final int limit;

    // Constructor for unlimited Fibonacci sequence
    public FibonacciSequence() {
        this.limit = -1;
    }

    // Constructor for limited Fibonacci sequence
    public FibonacciSequence(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit must be non-negative");
        }
        this.limit = limit;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(limit);
    }
}

