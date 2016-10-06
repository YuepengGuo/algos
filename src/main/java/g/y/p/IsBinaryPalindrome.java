package g.y.p;

public class IsBinaryPalindrome {
	/*
	 * origin.reverse == origin?
	 */
	static void isPalindrome_1(int a) {
		String str = Integer.toBinaryString(a);
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		String rev = sb.reverse().toString();
		if (str.equals(rev)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

	/*
	 * recursive
	 */
	static boolean isPalindrome_2(String s) {
		if (s.length() == 0 || s.length() == 1)
			return true;
		if (s.charAt(0) == s.charAt(s.length() - 1))
			return isPalindrome_2(s.substring(1, s.length() - 1));
		return false;
	}

	static void isPalindrome(int a) {
		int numOfBits = (int) (Math.floor((Math.log(a) / Math.log(2))) + 1);
		int left = 0;
		int right = numOfBits - 1;
		while (left < right) {
			if (isBitSet(a, numOfBits - left) != isBitSet(a, numOfBits - right)) {
				System.out.println("NO");
				break;
			}
			left++;
			right--;
		}
		System.out.println("YES");
	}

	static boolean isBitSet(int num, int index) {
		return (num & (1 << (index - 1))) != 0;
	}

	public static void main(String[] args) {
		int x = 0b10101;
		System.out.println(x);
		// System.out.println(Integer.toBinaryString(1<<3));
		// System.out.println(Integer.toBinaryString(100));
		// System.out.println(isBitSet(100,0));
		// System.out.println(isBitSet(100,1));
		// System.out.println(isBitSet(100,2));
		// System.out.println(isBitSet(100,3));
		// System.out.println(isBitSet(100,4));
		// System.out.println(isBitSet(100,5));
		// isPalindrome(100);
		isPalindrome_1(x);
		System.out.println(isPalindrome_2(Integer.toBinaryString(x)));
		isPalindrome(x);

	}
}
