package Exercise.HackerRank;

import java.math.BigInteger;

public class PowerMod {
    public static BigInteger powerMod(BigInteger base, BigInteger exponent, BigInteger modulus) {
        BigInteger result = BigInteger.ONE;
        while (exponent.compareTo(BigInteger.ZERO) > 0) {
            if (exponent.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                result = (result.multiply(base)).mod(modulus);
            }
            exponent = exponent.divide(BigInteger.valueOf(2));
            base = (base.multiply(base)).mod(modulus);
        }
        return result;
    }

    public static void main(String[] args) {
        BigInteger c = BigInteger.valueOf(1374);
        BigInteger d = BigInteger.valueOf(18);
        BigInteger n = BigInteger.valueOf(1457);

        BigInteger m = powerMod(c, d, n);
        System.out.println("Thông điệp gốc m là: " + m);
    }
}
