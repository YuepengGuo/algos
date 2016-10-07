package g.y.p;

/*
Reverse a linked list and return pointer to the head
The input list will have at least one element  
Node is defined as  
*/
class Node {
	int data;
	Node next;
}

// This is a "method-only" submission.
// You only need to complete this method.
public class ReverseListRecursive {
	Node Reverse(Node head) {
		if (head == null || head.next == null)
			return head;
		// two options, reverse next first or reverse pre first
		// we will reverse next parts first
		Node newTail = head.next;
		// cut
		head.next = null;
		// head or tail recursive
		Node newHead = Reverse(newTail);
		newTail.next = head;

		return newHead;
	}
}
