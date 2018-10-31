package tests;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.Random;

import model.Change;
import model.DotProduct;
import model.FractionalKnapsack;

public class Tests1 {
    
    @Test
    public void testChange() {
        assertTrue(Change.getChange(2) == 2);
        assertTrue(Change.getChange(28) == 6);
        assertTrue(Change.getChange(30) == 3);
        assertTrue(Change.getChange(1) == 1);
        assertTrue(Change.getChange(100) == 10);
        assertTrue(Change.getChange(10*10*10) == 100);
    }
    
    @Test
    public void testKnapsack() {
        assertEquals(FractionalKnapsack.
                getOptimalValue(50, new int[] {60, 100, 120}, new int[] {20, 50, 30}),180d, 0.0001);
        assertEquals(FractionalKnapsack.
                getOptimalValue(10, new int[] {500}, new int[] {30}), 166.6667, 0.0001);
    }
    
    @Test
    public void testBestItem() {
        assertTrue(FractionalKnapsack.bestItem(new int[] {60, 100, 120}, new int[] {20, 50, 30}) == 2);
    }
    
    @Test
    public void testDotProduct() {
        assertTrue(DotProduct.
                maxDotProduct(new int[] {1,  3, -5}, new int[] {-2, 4, 1}) == 23);
        assertTrue(DotProduct.
                maxDotProduct(new int[] {23}, new int[] {39}) == 897);
        System.out.println(DotProduct.maxDotProduct(new int[] {-2, -5, -10}, new int[] {4, 6, 9}));
        assertTrue(DotProduct.
                maxDotProduct(new int[] {-2, -5, -10}, new int[] {4, 6, 9}) == -18 - 40 - 30);
    }
    
    @Test
    public void testMaxDotProductNaiive() {
        assertTrue(DotProduct.
                maxDotProductNaiive(new int[] {1,  3, -5}, new int[] {-2, 4, 1}) == 23);
        assertTrue(DotProduct.
                maxDotProductNaiive(new int[] {23}, new int[] {39}) == 897);
        
        long i = DotProduct.maxDotProductNaiive(new int[] {-2, -5, -10}, new int[] {4, 6, 9});
        System.out.print(i);
        assertTrue(DotProduct.
                maxDotProductNaiive(new int[] {-2, -5, -10}, new int[] {4, 6, 9}) == (-18 - 40 - 30));
    }
    
    
}
