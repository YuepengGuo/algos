package g.y.p;

public class FindTwoRepeatingElementsInGivenArray {
	/*
	 * X + Y = S – n(n+1)/2
	 * XY = P/n!
	 * 
	 * Time Complexity: O(n)
	 * Auxiliary Space: O(1)
	 */
	static void printRepeating_1(int arr[], int size) {
		/* S is for sum of elements in arr[] */
		int S = 0;

		/* P is for product of elements in arr[] */
		int P = 1;

		/* x and y are two repeating elements */
		int x, y;

		/* D is for difference of x and y, i.e., x-y */
		int D;

		int n = size - 2, i;

		/* Calculate Sum and Product of all elements in arr[] */
		for (i = 0; i < size; i++) {
			S = S + arr[i];
			P = P * arr[i];
		}

		/* S is x + y now */
		S = S - n * (n + 1) / 2;

		/* P is x*y now */
		P = P / fact(n);

		/* D is x - y now */
		D = (int) Math.sqrt(S * S - 4 * P);

		x = (D + S) / 2;
		y = (S - D) / 2;

		System.out.println("The two repeating elements are :");
		System.out.print(x + " " + y);
	}

	static int fact(int n) {
		return (n == 0) ? 1 : n * fact(n - 1);
	}
	/*
	 * 
	 * Traverse the array once. While traversing, 
	 * keep track of count of all elements in the array using a temp array count[] of size n, 
	 * when you see an element whose count is already set, print it as duplicate.
	 * This method uses the range given in the question to restrict the size of count[], 
	 * but doesn’t use the data that there are only two repeating elements.
	 * 
	 * Time Complexity: O(n)
	 * Auxiliary Space: O(n)
	 */
    static void printRepeating_2(int arr[], int size) 
    {
        int count[] = new int[size];//space O(n)
        int i;
 
        System.out.println("\nRepeated elements are : ");
        for (i = 0; i < size; i++) 
        {
            if (count[arr[i]] == 1)
                System.out.print(arr[i] + " ");
            else
                count[arr[i]]++;
        }
    }
    
    /*
     * Let the repeating numbers be X and Y, 
     * if we xor all the elements in the array and all integers from 1 to n, 
     * then the result is X xor Y.
     * The 1’s in binary representation of X xor Y is 
     * corresponding to the different bits between X and Y. 
     * Suppose that the kth bit of X xor Y is 1, 
     * we can xor all the elements in the array and all integers from 1 to n, 
     * whose kth bits are 1. 
     * The result will be one of X and Y.
     * 
     */
    static void printRepeating_3(int arr[], int size) 
    {
        /* Will hold xor of all elements */
        int xor = arr[0];
         
        /* Will have only single set bit of xor */
        int set_bit_no;
         
        int i;
        int n = size - 2;
        int x = 0, y = 0;
 
        /* Get the xor of all elements in arr[] and {1, 2 .. n} */
        for (i = 1; i < size; i++)
            xor ^= arr[i];

        for (i = 1; i <= n; i++)
            xor ^= i;

        
        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = (xor & ~(xor - 1));
 
        /* Now divide elements in two sets by comparing rightmost set
           bit of xor with bit at same position in each element. */
        for (i = 0; i < size; i++) {
            int a = arr[i] & set_bit_no;
            if (a != 0)
                x = x ^ arr[i]; /*XOR of first set in arr[] */
            else
                y = y ^ arr[i]; /*XOR of second set in arr[] */
        }
        for (i = 1; i <= n; i++) 
        {
            int a = i & set_bit_no;
            if (a != 0)
                x = x ^ i; /*XOR of first set in arr[] and {1, 2, ...n }*/
            else
                y = y ^ i; /*XOR of second set in arr[] and {1, 2, ...n } */
        }
 
        System.out.println("\nThe two reppeated elements are :");
        System.out.println(x + " " + y);
    }
    
    /*
     * values in array should occur only once, marked as negative, otherwise, it appears twice
     */
    static void printRepeating_4(int arr[], int size)
    {
        int i;  
        System.out.println("The repeating elements are : ");
    
        for(i = 0; i < size; i++)
        {
            if(arr[Math.abs(arr[i])] > 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }         
    } 
 

	public static void main(String[] args) {
        int arr[] = {4, 2, 5, 5, 2, 3, 1};
        int arr_size = arr.length;
        printRepeating_1(arr, arr_size);
        printRepeating_2(arr, arr_size);
        printRepeating_3(arr, arr_size);
        printRepeating_4(arr, arr_size);
	}

}
