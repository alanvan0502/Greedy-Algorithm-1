package model;
import java.util.Scanner;

/**
Task. The goal of this code problem is to implement an algorithm 
for the fractional knapsack problem.
Input Format. The first line of the input contains the number 𝑛
of items and the capacity 𝑊 of a knapsack. The next 𝑛 lines define 
the values and weights of the items. The 𝑖-th line contains 
integers 𝑣𝑖 and 𝑤𝑖—the value and the weight of 𝑖-th item, respectively.
Constraints. 1 ≤ 𝑛 ≤ 10^3, 0 ≤ 𝑊 ≤ 2·10^6; 0 ≤ 𝑣𝑖 ≤ 2·10^6, 0 < 𝑤𝑖 ≤ 2·10^6 for all 1 ≤ 𝑖 ≤ 𝑛.
All the numbers are integers.
Output Format. Output the maximal value of fractions of items that fit into the knapsack. 
The absolute value of the difference between the answer of your program and the optimal value 
should be at most 10^(−3). To ensure this, output your answer with at least four digits after 
the decimal point (otherwise your answer, while being computed correctly, can turn out 
to be wrong because of rounding issues).
*/
public class FractionalKnapsack {
    public static double getOptimalValue(int capacity, int[] values, int[] weights) {
        int[] amounts = new int[values.length];
        int remainingCapacity = capacity;
        double totalValue = 0;
        for (int i = 0; i < values.length; i++) {
            if (remainingCapacity == 0) {
                return totalValue;
            } else {
                int bi = bestItem(values, weights);
                int a = weights[bi] < remainingCapacity ? weights[bi] : remainingCapacity;
                totalValue += (double)a * (double)values[bi]/(double)weights[bi];
                remainingCapacity -= a;
                weights[bi] -= a;
                amounts[i] += a;
            }
        }
        return (double) Math.round(totalValue * 10000)/10000;
    }
    /**
     * Find the index of the item with the maximum value per unit weight
     * @param values
     * @param weights
     * @return index of the best item
     */
    public static int bestItem(int[] values, int[] weights) {
        double maxValuePerWeight = 0;
        int bestIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if (weights[i] == 0) continue;
            else if ((double)values[i] / (double)weights[i] > maxValuePerWeight) {
                maxValuePerWeight = (double)values[i] / (double)weights[i];
                bestIndex = i;
            }
        }
        return bestIndex;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
