package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.LargestNumber;

public class Tests3 {
    @Test
    public void testLargestNumber() {
        assertTrue(LargestNumber.largestNumber(new String[] {"21", "2"}).equals("221"));
        assertTrue(LargestNumber.largestNumber(new String[] {"9", "4", "6", "9"}).equals("9964"));
        assertTrue(LargestNumber.largestNumber(new String[] {"23", "39", "92"}).equals("923923"));
    }
}
