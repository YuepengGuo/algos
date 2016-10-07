package g.y.p;

import java.util.Stack;

/**
 * <pre>
 * our algorithm:
 * 1. Push the root of the tree onto the stack.
 * 2. Until the stack is empty, keep on popping the top of stack, print it and execute step #3 and step #4.
 * 3. If the top of stack obtained in step #2 has a right child then push it onto the stack.
 * 4. If the top of stack obtained in step #2 has a left child then push it onto the stack.
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Tree_traversal">Tree Traversal Wiki</a>
 * We can use callback to print or ...
 * 
 * def traverse_binary_tree(node, callback):
    if node is None:
        return
    traverse_binary_tree(node.leftChild, callback)
    callback(node.value)
    traverse_binary_tree(node.rightChild, callback)
    
 * </pre>
 */
public class TreeTraverseWithoutRecursion {
	private TreeNode root;

	class TreeNode {
		private int data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	};

	public void createTree() {
		root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(8);
	}

	public void iterativePreorder() {
		TreeNode top;
		if (root == null)
			return;

		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);

		while (!st.empty()) {
			top = st.pop();
			System.out.print(top.data + " ");
			if (top.right != null)
				st.push(top.right);
			if (top.left != null)
				st.push(top.left);
		}
	}

	public static void main(String args[]) {
		TreeTraverseWithoutRecursion tree = new TreeTraverseWithoutRecursion();
		tree.createTree();
		tree.iterativePreorder();
	}
}
