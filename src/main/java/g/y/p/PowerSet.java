package g.y.p;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * If S = (a, b, c) then the powerset(S) is the set of all subsets powerset(S) =
 * {(), (a), (b), (c), (a,b), (a,c), (b,c), (a,b,c)}
 * 
 * http://www.ecst.csuchico.edu/~amk/foo/csci356/notes/ch1/solutions/
 * recursionSol.html
 * 
 * powerset(S) when S = {()} is {()} powerset(S) when S = {(a)} is {(), (a)}
 * powerset(S) when S = {(a,b)} is {(), (a), (b), (a,b)}
 * 
 * http://javabypatel.blogspot.in/2015/10/all-subsets-of-set-powerset.html
 *
 */
public class PowerSet {

	private static List<String> createSubsetUsingTree(String str) {

		List<String> result = new ArrayList<String>(); // take set if you want
														// unique results.
		result.add("[]");

		// If str is not null, then process further otherwise return empty set.
		if (str != null && str.length() > 0) {

			// Iterate each element of a set
			for (int i = 0; i < str.length(); i++) {
				System.out.println(i);

				// Working on str.charAt(i);
				// Store the result of subset of str.charAt(i) in tempList.
				List<String> tempList = new ArrayList<String>();

				// Add str.charAt(i) in each item of result.
				Iterator<String> iter = result.iterator();
				while (iter.hasNext()) {
					String val = iter.next();
					System.out.println("---1-->"+val);

					// If val is [], it means str.charAt(i) is not included, So
					// include it in result.
					if (val.equals("[]")) {
						System.out.println("---2-->"+"[" + str.charAt(i) + "]");	
						tempList.add("[" + str.charAt(i) + "]");
					} else {

						// For each item, there will be 2 subset, one including
						// it and one without including it.
						// If val is not [], it means it already contain some
						// subset without str.charAt(i), So just include it.
						System.out.println("----3---->"+"[" + val.substring(1, val.length() - 1) + ", " + str.charAt(i) + "]");
						tempList.add("[" + val.substring(1, val.length() - 1) + ", " + str.charAt(i) + "]");
					}
				}
				
				// Add all subsets present in tempList to final result.
				result.addAll(tempList);
				System.out.println("--------4------>"+tempList);
			}
		}

		return result;
	}

	private static Set<Set<Object>> getSubsetUsingBitMap(List<Object> list) {

		Set<Set<Object>> result = new HashSet<Set<Object>>();

		int numOfSubsets = 1 << list.size(); // OR Math.pow(2, list.size())

		// For i from 0 to 7 in case of [a, b, c],
		// we will pick 0(0,0,0) and check each bits to see any bit is set,
		// If set then element at corresponding position in a given Set need to
		// be included in a subset.
		for (int i = 0; i < numOfSubsets; i++) {

			Set<Object> subset = new HashSet<Object>();

			int mask = 1; // we will use this mask to check any bit is set in
							// binary representation of value i.

			for (int k = 0; k < list.size(); k++) {

				if ((mask & i) != 0) { // If result is !=0 (or >0) then bit is
										// set.
					subset.add(list.get(k)); // include the corresponding
												// element from a given set in a
												// subset.
				}

				// check next bit in i.
				mask = mask << 1;
			}

			// add all subsets in final result.
			result.add(subset);
		}
		return result;
	}

	static void powerSet(int a[]) {
		int count = 1 << a.length;
		List<List<Integer>> l = new LinkedList<>();
		for (int i = 0; i < count; i++) {
			List<Integer> temp = new LinkedList<>();
			for (int j = 0; j < a.length; j++) {
				if ((i & 1 << j) != 0) {
					temp.add(a[j]);
				}
			}
			l.add(temp);
		}
		System.out.println(l);
	}

	public static void main(String[] args) {
		// int a[] = { 1, 2, 3 };
		// powerSet(a);
		System.out.println("\n" + createSubsetUsingTree("ABCD"));

		List<Object> list = new ArrayList<Object>();
		list.add("a");
		list.add("b");
		list.add("c");

		System.out.println(getSubsetUsingBitMap(list));
	}
}
