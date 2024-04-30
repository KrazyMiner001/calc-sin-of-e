import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Objects;

public class ECalculator {
    private static BigInteger p(BigInteger a, BigInteger b) {
        if (Objects.equals(b, a.add(BigInteger.ONE))) {
            return BigInteger.ONE;
        }
        BigInteger m = a.add(b).divide(BigInteger.TWO);
        return p(a, m).multiply(q(m, b)).add(p(m, b));
    }

    private static BigInteger q(BigInteger a, BigInteger b) {
        if (b.equals(a.add(BigInteger.ONE))) {
            return b;
        }
        BigInteger m = a.add(b).divide(BigInteger.TWO);
        return q(a, m).multiply(q(m, b));
    }

    public static BigDecimal calcE(int n, int precision) {
        BigDecimal partialSum = new BigDecimal(p(BigInteger.ZERO, BigInteger.valueOf(n))).divide(new BigDecimal(q(BigInteger.ZERO, BigInteger.valueOf(n))), new MathContext(precision));
        return partialSum.add(BigDecimal.ONE);
    }
}
