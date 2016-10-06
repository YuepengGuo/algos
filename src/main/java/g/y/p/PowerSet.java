package g.y.p;

import java.util.LinkedList;
import java.util.List;

/**
 * If S = (a, b, c) 
 * then the powerset(S) is the set of all subsets
 * powerset(S) = {(), (a), (b), (c), (a,b), (a,c), (b,c), (a,b,c)}
 * 
 * http://www.ecst.csuchico.edu/~amk/foo/csci356/notes/ch1/solutions/recursionSol.html
 * 
 * powerset(S) when S = {()} is {()}
 * powerset(S) when S = {(a)} is {(), (a)}
 * powerset(S) when S = {(a,b)} is {(), (a), (b), (a,b)}
 *
 */
public class PowerSet {
	static void powerSet(int a[]) {
		int count = 1<<a.length;
		List<List<Integer>> l = new LinkedList<>();
		for(int i=0;i<count;i++) {
			List <Integer> temp = new LinkedList<>();
			for(int j=0;j<a.length;j++) {
				if((i & 1<<j) != 0) {
					temp.add(a[j]);
				}
			}
			l.add(temp);
		}
		System.out.println(l);
	}
	
	public static void main(String[] args) {
		int a[]= {1, 2, 3};
		powerSet(a);
	}
}
