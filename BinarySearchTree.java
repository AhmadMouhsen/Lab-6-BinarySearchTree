package lab6;
import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> {
	
	Node root;
	
	BinarySearchTree(Node n) {
		root = n;
	}
	
	public class Node<E extends Comparable<E>> {
		int data;
		Node subLeft;
		Node subRight;
	}
	
	boolean add(E item) {
		return false;
	}
	
	E remove(E item) {
		return null;
	}
	
	boolean find(E item) {
		return false;
	}

	E getParent(E item) {
		return null;
	}
	
	ArrayList<E> getAllDescendant(E item) {
		return null;
	}
	
	E getMax() {
		return null;
	}
	
	int getHeight() {
		return 0;
	}
	
	int getLevel(E item) {
		return 0;
	}
	
	void inOrder() {
		return;
	}
	
	void preOrder() {
		return;
	}
	
	void postOrder() {
		return;
	}
	
	ArrayList<E> bfs() {
		return null;
	}
	
	boolean isIdentical(Node<E> anotherTree) {
		return false;
	}
	
	int numLeaves() {
		return 0;
	}
	
	int numInternal() {
		return 0;
	}
	
	void clear() {
		return;
	}
}
