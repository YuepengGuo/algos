package g.y.p;

class TreeNode {

	public TreeNode left;
	public int data;
	public TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return this.data+"";
	}
}

public class IsBalancedTree {

	static int height(TreeNode root) {
		if(root == null) return 0;
		
		return(Math.max(height(root.left), height(root.right)))+1;
	}
	
	static boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		int diff = leftHeight>rightHeight?leftHeight-rightHeight:rightHeight-leftHeight;
		if(diff<=1) {
			return (isBalanced(root.left) && isBalanced(root.right));
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
//		root.left.left = new Node(4);
		
		System.out.println(isBalanced(root));
	}
}
