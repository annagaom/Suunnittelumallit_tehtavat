package Iterator;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int previous = 1; // F(n-2), alustettu arvoon 1
    private int current = 1;  // F(n-1), alustettu arvoon 1
    private int count = 0;    // Seuraa nykyistä kohtaa sekvenssissä
    private final int limit;  // Valinnainen rajoitus iteraattorille

    public FibonacciIterator(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Rajoituksen on oltava nolla tai positiivinen");
        }
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return limit < 0 || count < limit;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalStateException("Ei enää alkioita Fibonacci-sekvenssissä");
        }

        count++;
        if (count <= 2) {
            return 1; // Ensimmäiset kaksi lukua ovat aina 1
        }

        // Lasketaan seuraava luku ja päivitetään arvot
        int next = previous + current;
        previous = current;
        current = next;

        return next;
    }
}
