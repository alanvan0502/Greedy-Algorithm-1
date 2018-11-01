package model;

import java.math.BigInteger;
import java.util.*;

public class LargestNumber {
    public static final String MIN_VALUE = String.valueOf(Integer.MIN_VALUE);
    public static String largestNumber(String[] a) {
        ArrayList<String> digits = new ArrayList<>();
        digits.addAll(Arrays.asList(a));
        
        String answer = "";
        
        while (!digits.isEmpty()) {
            String bestDigit = getBestDigit(digits);
            answer += bestDigit;
            digits.remove(bestDigit);
        }
        
        BigInteger result = new BigInteger(answer);
        
        return result.toString();
    }

    private static String getBestDigit(List<String> digits) {
        String bestDigit = MIN_VALUE;
        for (String digit : digits) {
            if (isBetter(digit, bestDigit))
                bestDigit = digit;
        }
        return bestDigit;
    }

    /**
     * @param digit
     * @param bestDigit
     * @return Return true if digit1 is better than digit2 (to create a larger number)
     * Example: 22 is better than 11
     *          21 is not better than 2
     *          13 is not better than 2
     *          341 is not better than 45
     */
    private static boolean isBetter(String digit1, String digit2) {
        if (digit2.equals(MIN_VALUE)) return true;
        
        String d1 = digit1 + digit2;
        String d2 = digit2 + digit1;
        
        return (Integer.parseInt(d1) > Integer.parseInt(d2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
