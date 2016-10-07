package g.y.p;

public class SwapWithoutTemp {

	public static void main(String[] args) {
		int a = 10, b = 20;
		//sum
		a= a + b;
		//sum - b = a , and assign it to b
		b = a - b;
		//sum - a = b, and assign it to a
		a = a - b;
		
		System.out.println(a);
		System.out.println(b);

	}

}
