package g.y.p;

import java.util.Stack;

public class KSmallestBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (stack != null || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				k--;
				if (k == 0)
					return p.val;
				p = p.right;
			}
		}

		return -1;
	}
}
