package g.y.p;

public class TowersOfHanoi {
	public void towers(int n, String start, String middle, String end) {
		if(n == 1) {
			System.out.println(start+" ---> "+end);
			return;
		}
		towers(n-1, start, end, middle);
		System.out.println(start+" ---> "+end);
		towers(n-1, middle, start, end);
	}
	static int trailingZeros(int n) {
		if(n>=5) return trailingZeros(n/5)+n/5;
		return 0;
	}
	public static void main(String[] args) {
		TowersOfHanoi t = new TowersOfHanoi();
		t.towers(3, "A", "B", "C");
		System.out.println(trailingZeros(10));
	}
}
