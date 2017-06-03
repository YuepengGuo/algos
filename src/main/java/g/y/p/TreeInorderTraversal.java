package g.y.p;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Tree_traversal">Tree Traversal Wiki</a>
 *
 */
public class TreeInorderTraversal {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode p = root;
		while (!st.isEmpty() || p != null) {
			if (p != null) {
				st.push(p);
				p = p.left;
			} else {
				p = st.pop();
				//visit
				res.add(p.val);
				p = p.right;
			}
		}
		return res;
	}

	public List<Integer> preOrderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode p = root;
		while (!st.isEmpty() || p != null) {
			if (p != null) {
				//visit
				res.add(p.val);
				st.push(p);
				p = p.left;
			} else {
				p = st.pop();
				p = p.right;
			}
		}
		return res;
	}

    public List<Integer> preOrderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode n = st.pop();
            res.add(n.val);
            if(n.right!=null){st.push(n.right);}
            if(n.left!=null){st.push(n.left);}
        }
        return res;
    }

	public List<Integer> postOrderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		while(!st.isEmpty()){
			TreeNode temp = st.peek();
			if(temp.right==null && temp.left==null){
				TreeNode t = st.pop();
				res.add(t.val);
			}else {
				if(temp.right!=null){
					st.push(temp.right);
                    //maintain order in stack only
					temp.right = null;
				}
				if(temp.left!=null){
					st.push(temp.left);
					temp.left = null;
				}
			}
		}
		return res;
	}
	public TreeNode createTree() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
		return root;
	}
	public static void main(String args[]) {
		TreeInorderTraversal tree = new TreeInorderTraversal();
		TreeNode root = tree.createTree();
		System.out.println(tree.inorderTraversal(root));
		System.out.println(tree.preOrderTraversal(root));
        System.out.println(tree.preOrderTraversal2(root));
		System.out.println(tree.postOrderTraversal(root));
	}
}
