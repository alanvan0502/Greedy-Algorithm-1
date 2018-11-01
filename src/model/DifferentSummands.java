package model;

import java.util.*;

public class DifferentSummands {
    public static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int last = 0;
        while (n > 0) {
            int focus = last + 1;
            if (n > 2 * focus) {
                n -= focus;
                summands.add(focus);
                last = focus;
            } else {
                summands.add(n);
                n = 0;
            }
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}
