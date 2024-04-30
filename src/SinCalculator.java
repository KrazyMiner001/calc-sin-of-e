import java.math.BigDecimal;
import java.math.MathContext;

public class SinCalculator {
    public static BigDecimal calcSinX(BigDecimal x, int n, int precision) {
        BigDecimal sinX = new BigDecimal(0);

        for (int i = 0; i < n; i++) {
            BigDecimal numerator = x.pow(2*i+1);
            BigDecimal denominator = FactorialCalc.factorialOf(2*i+1);
            sinX = sinX.add(negativeOneToN(i).multiply(numerator.divide(denominator, new MathContext(precision))));
        }
        return sinX;
    }

    private static BigDecimal negativeOneToN(int n) {
        if (n % 2 == 0) {
            return BigDecimal.ONE;
        }
        return new BigDecimal(-1);
    }
}
