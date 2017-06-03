package g.y.p;

import java.util.Arrays;

/**
 * <pre>
 *  S[n][W] tells us whether it is possible to choose a subset from the first n numbers in A, 
 *  i.e. all numbers in A, such that their sum equals W. 
 *  In order to compute that last entry we have to fill the table S via the following relationship:
 *  S[i][s] = S[i-1][s] | S[i-1][s-A[i]]
 *  
 *  https://algocoding.wordpress.com/2015/05/01/subset-sum-and-dynamic-programming/
 *  
 * </pre>
 */
public class SubsetSum {
	private static Integer[] options;
	private static int[] visited;
	private static int desiredSum;

	public static void sumOfSubsets(int index, int curSum, int remainSum) {
		visited[index] = 1;
		if (options[index] + curSum == desiredSum)// if result found print
													// result with for loop
		{
			System.out.println("The Solutions are:");
			for (int i = 0; i <= index; i++) {
				if (visited[i] == 1) {
					System.out.print(options[i] + " ");
				}
			}
			System.out.println();
		} // result not found yet. take both, are within bounds and can take
			// next index value.
		else if (index + 1 < options.length && curSum + options[index] + options[index + 1] <= desiredSum) {
			// take index and call as required.
			sumOfSubsets(index + 1, curSum + options[index], remainSum - options[index]);
		}
		// within bounds take next only current exceeds bound
		if (index + 1 < options.length && curSum + options[index + 1] <= desiredSum
				&& curSum + remainSum - options[index] >= desiredSum)

		{
			// so skip and unvisit index and do as required.
			visited[index] = 0;
			sumOfSubsets(index + 1, curSum, remainSum - options[index]);
		}
	}

	public static void main(String[] args) {
		options = new Integer[] { 1, 2, 3, 7, 4, 5, 6, 7, 8, 9, 10 };
		visited = new int[options.length];
//		Arrays.sort_with_helper_array(options);
		// System.out.println("Please enter the desired sum");
		desiredSum = 10;
		int totalSum = 0;
		for (int item : options) {
			totalSum += item;
		}
		// initially both sums are zero
		sumOfSubsets(0, 0, totalSum);
	}
}
