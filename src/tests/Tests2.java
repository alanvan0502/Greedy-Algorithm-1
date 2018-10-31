package tests;

import org.junit.Test;
import static org.junit.Assert.*;

import model.CoveringSegments;
import model.CoveringSegments.Segment;

public class Tests2 {
    
    @Test
    public void testOptimalPoint1() {
        Segment s1 = new Segment(1, 3);
        Segment s2 = new Segment(2, 5);
        Segment s3 = new Segment(3, 6);
        
        Segment[] segments = new Segment[] {s1, s2, s3};
        int[] ans = CoveringSegments.optimalPoints(segments);
        assertTrue(ans[0] == 3);
    }
    
    @Test
    public void testOptimalPoint2() {
        Segment s1 = new Segment(4, 7);
        Segment s2 = new Segment(1, 3);
        Segment s3 = new Segment(2, 5);
        Segment s4 = new Segment(5, 6);
        
        Segment[] segments = new Segment[] {s1, s2, s3, s4};
        int[] ans = CoveringSegments.optimalPoints(segments);
        assertTrue(ans[0] == 3);
        assertTrue(ans[1] == 6);
    }
    
    @Test
    public void testOptimalPoint3() {
        Segment s1 = new Segment(0, 3);
        Segment s2 = new Segment(2, 11);
        Segment s3 = new Segment(10, 12);
        Segment s4 = new Segment(13, 15);
        Segment s5 = new Segment(11, 14);
        
        Segment[] segments = new Segment[] {s1, s2, s3, s4, s5};
        int[] ans = CoveringSegments.optimalPoints(segments);
        assertTrue(ans[0] == 3);
        assertTrue(ans[1] == 12);
        assertTrue(ans[2] == 15);
    }
    
    @Test
    public void testOptimalPoint4() {
        Segment s1 = new Segment(1, 3);
        Segment s2 = new Segment(2, 7);
        Segment s3 = new Segment(5, 6);
        Segment s4 = new Segment(7, 9);
        
        Segment[] segments = new Segment[] {s1, s2, s3, s4};
        int[] ans = CoveringSegments.optimalPoints(segments);
        assertTrue(ans[0] == 3);
        assertTrue(ans[1] == 6);
        assertTrue(ans[2] == 9);
    }
    
    @Test
    public void testOptimalPoint5() {
        Segment s1 = new Segment(1, 3);
        Segment s2 = new Segment(2, 7);
        Segment s3 = new Segment(4, 9);
        Segment s4 = new Segment(5, 6);
        
        Segment[] segments = new Segment[] {s1, s2, s3, s4};
        int[] ans = CoveringSegments.optimalPoints(segments);
        assertTrue(ans[0] == 3);
        assertTrue(ans[1] == 6);
    }
    
}
