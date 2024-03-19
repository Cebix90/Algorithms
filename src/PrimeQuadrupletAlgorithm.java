import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class PrimeQuadrupletAlgorithm {
    private final int n;

    public PrimeQuadrupletAlgorithm(int n) {
        this.n = n;
    }
    private List<Integer> getPrimeNumbers() {
        BitSet primes = new BitSet(n + 1);
        primes.set(2, n + 1);

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (primes.get(i)) {
                for (int j = i * i; j <= n; j += 2 * i) {
                    primes.clear(j);
                }
            }
        }

        List<Integer> primeList = new ArrayList<>();
        primeList.add(2);

        for (int i = 3; i <= n; i += 2) {
            if (primes.get(i)) {
                primeList.add(i);
            }
        }

        return primeList;
    }

    public void printPrimeQuadruplets() {
        List<Integer> primes = getPrimeNumbers();

        System.out.println("Prime quadruplet:");
        for (int i = 0; i < primes.size() - 3; i++) {
            int prime1 = primes.get(i);
            int prime2 = primes.get(i + 1);
            int prime3 = primes.get(i + 2);
            int prime4 = primes.get(i + 3);

            if (prime1 + 2 == prime2 && prime1 + 6 == prime3 && prime1 + 8 == prime4) {
                System.out.println(prime1 + ", " + prime2 + ", " + prime3 + ", " + prime4);
            }
        }
    }
}
