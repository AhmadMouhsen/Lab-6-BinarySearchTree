package tree;

public class BinaryTree {
	
	public boolean isIdentical(Node<E> anotherTree) {
		
		
		
	}
	
	public int numLeaves(Node<E> node) {
		if (node == null) {
			return 0;
		}
		
		else if ((node.left == null) && (node.right == null)) {
			return 1;
		}
		
		return numLeaves(node.left) + numLeaves(node.right);
	}
	
	public int numInternal(Node<E> node) {
		
		if ((node == null) || (node.left = null && node.right == null)) {
			return 0;
		}
		
		else if ()
		
	}
	
	public BinaryTree clear() {
		
		
	}

}
