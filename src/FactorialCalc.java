import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FactorialCalc {
    private static Map<Integer, BigDecimal> factorialMap = new HashMap<>(Map.of(0, BigDecimal.ONE));

    public static BigDecimal factorialOf(int n) {
        BigDecimal factorial = factorialMap.get(n);
        if (factorial != null) {
            return factorial;
        }
        addFactorialToFactorialMap(n);
        return factorialMap.get(n);

    }

    private static void addFactorialToFactorialMap(int n) {
        BigDecimal factorial = factorialMap.get(n-1);
        if (factorial != null) {
            factorialMap.put(n, factorial.multiply(new BigDecimal(n)));
            return;
        }
        addFactorialToFactorialMap(n - 1);
        factorial = factorialMap.get(n-1);
        factorialMap.put(n, factorial.multiply(new BigDecimal(n)));

    }
}
