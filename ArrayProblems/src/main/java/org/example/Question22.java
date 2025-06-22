import java.math.BigInteger;

public class Question22 {
    public static void main(String[] args) {
        int n = 25;
        System.out.println(n + "! =\n" + factorial(n));
    }
    public static BigInteger factorial(int n){
        BigInteger fact = BigInteger.ONE;
        for(int i=2; i<=n; i++){
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
}