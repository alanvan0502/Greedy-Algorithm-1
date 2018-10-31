package model;

import java.util.*;

public class DotProduct {
    public static final int LIMIT = (int) Math.pow(10, 5);
    
    public static long maxDotProductNaiive(int[] a, int[] b) {
        List<List<Integer>> possibleResults = generate(a, b);
        
        long result = Long.MIN_VALUE;
        for (int i = 0; i < possibleResults.size(); i++) {
            long temp = sum(possibleResults.get(i));
            if (temp > result) result = temp;
        }
        return result;
    }


    private static List<List<Integer>> generate(int[] a, int[] b) {
        List<List<Integer>> possibleResults = new ArrayList<>();
        int maxCount = (int) Math.pow(a.length, b.length);
        int count = 0;
        while (count < maxCount) {
            List<Integer> randomList = randomSelect(a, b);
            if (!possibleResults.contains(randomList)) {
                possibleResults.add(randomList);
                count += 1;
            }
        }
        return possibleResults;
    }
    
    
    private static long sum(List<Integer> list) {
        long result = 0;
        if (list.isEmpty()) {
            return result;
        } else {
            return list.get(0)*list.get(1) + sum(list.subList(2, list.size()));
        }
    }


    private static List<Integer> randomSelect(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        List<Integer> aIndexes = new ArrayList<>();
        List<Integer> bIndexes = new ArrayList<>();
        
        Random rand = new Random();
              
        for (int i = 0; i < a.length; i++) {
            while(true) {
                int aIndex = rand.nextInt(a.length);
                if (!aIndexes.contains(aIndex)) {
                    result.add(a[aIndex]);
                    aIndexes.add(aIndex);
                    break;
                }
            }
            
            while(true) {
                int bIndex = rand.nextInt(b.length);
                if (!bIndexes.contains(bIndex)) {
                    result.add(b[bIndex]);
                    bIndexes.add(bIndex);
                    break;
                }
            }  
        }  
        
        return result;
    }


    public static long maxDotProduct(int[] a, int[] b) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            listA.add(a[i]);
            listB.add(b[i]);
        }
        listA.sort(null);
        listB.sort(null);
        
        long result = 0;
        for (int i = 0; i < listA.size(); i++) {
            result += (long)listA.get(i) * listB.get(i);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}