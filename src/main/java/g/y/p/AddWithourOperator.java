package g.y.p;

public class AddWithourOperator {
	static int add(int a, int b) {
		if (b == 0)
			return a;
		return add(a ^ b, (a & b) << 1);
	}

	static int subtract(int a, int b) {
		if (b == 0)
			return a;
		return subtract(a ^ b, (~a & b) << 1);
	}

	public static void main(String[] args) {
		System.out.println(subtract(100, 230));
		System.out.println(add(111, 230));
	}
}
