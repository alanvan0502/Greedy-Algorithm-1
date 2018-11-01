package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import model.DifferentSummands;
import model.LargestNumber;

public class Tests3 {
    @Test
    public void testLargestNumber() {
        assertTrue(LargestNumber.largestNumber(new String[] {"21", "2"}).equals("221"));
        assertTrue(LargestNumber.largestNumber(new String[] {"9", "4", "6", "9"}).equals("9964"));
        assertTrue(LargestNumber.largestNumber(new String[] {"23", "39", "92"}).equals("923923"));
    }
    
    @Test
    public void testDifferentSummands() {
        List<Integer> ans1 = Arrays.asList(1, 2, 3);
        assertEquals(DifferentSummands.optimalSummands(6), ans1);
        List<Integer> ans2 = Arrays.asList(1, 2, 5);
        assertEquals(DifferentSummands.optimalSummands(8), ans2);
        List<Integer> ans3 = Arrays.asList(2);
        assertEquals(DifferentSummands.optimalSummands(2), ans3);
        List<Integer> ans4 = Arrays.asList(1, 2, 6);
        assertEquals(DifferentSummands.optimalSummands(9), ans4);
        List<Integer> ans5 = Arrays.asList(1, 2, 3, 4);
        assertEquals(DifferentSummands.optimalSummands(10), ans5);
    }
}
