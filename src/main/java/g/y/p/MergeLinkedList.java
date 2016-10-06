package g.y.p;

class SingleNode {
	int data;
	SingleNode next;

	public SingleNode(int data) {
		this.data = data;
	}
}

public class MergeLinkedList {
	/*
	 * recursive
	 */
	public static SingleNode merge_1(SingleNode a, SingleNode b, SingleNode result) {
		if (a == null) {
			// result = b;
			return b;
		}
		if (b == null) {
			// result = a;
			return a;
		}

		if (a.data <= b.data) {
			result = a;
			result.next = merge_1(a.next, b, result.next);
		} else {
			result = b;
			result.next = merge_1(a, b.next, result.next);
		}
		return result;
	}

	public static SingleNode merge_2(SingleNode l1, SingleNode l2) {
		SingleNode head = new SingleNode(0);
		SingleNode p = head;

		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.data < l2.data) {
					p.next = l1;
					l1 = l1.next;
				} else {
					p.next = l2;
					l2 = l2.next;
				}
				p = p.next;
			} else if (l1 == null) {
				p.next = l2;
				break;
			} else if (l2 == null) {
				p.next = l1;
				break;
			}
		}

		return head.next;
	}

	public static void main(String[] args) {
		SingleNode a = new SingleNode(1);
		a.next = new SingleNode(2);

		SingleNode b = new SingleNode(2);
		b.next = new SingleNode(4);
		SingleNode result = null;
//		result = merge_1(a, b, result);
//		while (result != null) {
//			System.out.print(result.data + " ");
//			result = result.next;
//		}
		result = merge_2(a, b);

		while (result != null) {
			System.out.print(result.data + " ");
			result = result.next;
		}
	}
}
