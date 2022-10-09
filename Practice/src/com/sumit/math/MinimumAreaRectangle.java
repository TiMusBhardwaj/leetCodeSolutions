package com.sumit.math;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class MinimumAreaRectangle {
	
	public static void main(String[] args) {
		int [][] points = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
		int area = new Solution().minAreaRect(points);
		System.out.println(area);
	}

	
	static class Solution {
		int minSize = Integer.MAX_VALUE;
		Set<Point> visited = new HashSet<>();
	    public int minAreaRect(int[][] points) {
	    	
	    	for (int i =0; i< points.length;i++) {
	    		Point p1 = new Point(points[i][0], points[i][1]);
	    		Iterator<Point> it = visited.iterator();
	    		while (it.hasNext()) {
					Point p2 =  it.next();
					if (visited.contains(new Point(p1.x, p2.y) ) && visited.contains(new Point(p2.x, p1.y))){
						int size = (Math.abs(p2.y-p1.y)*Math.abs(p2.x-p1.x));
						minSize = Math.min(size, minSize);
						
					}
					
				}
	    		visited.add(p1);
	    	}
			return minSize;
	        
	    }
	    
	    static class Point{
			int x;
			int y;
			public Point(int x, int y) {
				super();
				this.x = x;
				this.y = y;
			}
			@Override
			public int hashCode() {
				return Objects.hash(x, y);
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Point other = (Point) obj;
				return x == other.x && y == other.y;
			}
			@Override
			public String toString() {
				return "Point [x=" + x + ", y=" + y + "]";
			}
			
			
		}
	}
	
	
}
