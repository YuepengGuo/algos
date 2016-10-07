package g.y.p;

import java.util.Arrays;

public class TrappingRainWater {
	/**
	 * <pre>
	 * Consider each bar at a time, we can see that, for each bar, 
	 * <b>the water itself can trap depends on the max height on its left and right,</b>
	 * say, if current bar is of height 2, the max height on its left is 4, max height on its right is 3,   then water can be trapped in this bar is min(4,3)-2 = 1.
	 * Thus, we can scan the whole map twice to get the max height on right and left, respectively. 
	 * Finally scan the map again to get the water trapped of all.
	 * </pre>
	 */
	static void trapWater(int a[]) {
		int quantity = 0;
		int right[]=new int[a.length];
		int left[]=new int[a.length];
		
		left[0]=a[0];
		for(int i=1;i<a.length;i++) {
			left[i] = Math.max(left[i-1], a[i]);
		}
		
		right[a.length-1] = a[a.length-1];
		for(int i=a.length-2;i>=0;i--) {
			right[i] = Math.max(right[i+1], a[i]);
		}
		
		for(int i=0;i<a.length;i++) {
			quantity += Math.min(left[i], right[i])-a[i];
		}
		System.out.println("a: "+Arrays.toString(a));
		System.out.println("l: "+Arrays.toString(left));
		System.out.println("r: "+Arrays.toString(right));
		System.out.println(quantity);
	}
	
	public static void main(String[] args) {
		int a[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		
		trapWater(a);
	}
}
