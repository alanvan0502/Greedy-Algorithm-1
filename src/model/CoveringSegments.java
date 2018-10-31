package model;

import java.util.*;

public class CoveringSegments {

    public static int[] optimalPoints(Segment[] segments) {
        //write your code here
        List<Integer> result = new ArrayList<>();
        List<Segment> sortedSegList = sortByStartingPoint(segments);

        while (!sortedSegList.isEmpty()) {
            int size = sortedSegList.size();
            List<Segment> focus = new ArrayList<>();
            Segment firstSeg = sortedSegList.get(0);
            focus.add(firstSeg);
            populateFocus(sortedSegList, focus, firstSeg);
            int bestPoint = getBestPoint(focus);
            result.add(bestPoint);
            sortedSegList.removeAll(focus);
        }
        
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }

    private static void populateFocus(List<Segment> sortedSegList, List<Segment> focus, Segment firstSeg) {
        for (int i = 1; i < sortedSegList.size(); i++) {
            Segment nextSeg = sortedSegList.get(i);
            if (nextSeg.start <= firstSeg.end) {
                focus.add(nextSeg);
            }
        }
    }

    private static int getBestPoint(List<Segment> focus) {
        int bestPoint = Integer.MAX_VALUE;
        for (Segment s: focus) {
            if (s.end <= bestPoint)
                bestPoint = s.end;
        }
        return bestPoint;
    }

    private static List<Segment> sortByStartingPoint(Segment[] segments) {
        List<Segment> result = new ArrayList<>();
        for (int i = 0; i < segments.length; i++) {
            result.add(segments[i]);
        }
        result.sort(new Comparator<Segment>() {

            @Override
            public int compare(Segment s1, Segment s2) {
                return s1.end - s2.end;
            }
        });
        return result;
    }

    public static class Segment {
        int start, end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + end;
            result = prime * result + start;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Segment)) {
                return false;
            }
            Segment other = (Segment) obj;
            if (end != other.end) {
                return false;
            }
            if (start != other.start) {
                return false;
            }
            return true;
        }
        
        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 

