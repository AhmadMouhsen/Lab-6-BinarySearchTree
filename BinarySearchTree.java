import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> {

	private Node root;
	private ArrayList<E> bfs = new ArrayList<E>();
	private ArrayList<E> allDescendant = new ArrayList<E>();
	private int indidualNodeLevel = 1;
	
	public BinarySearchTree() {
		root = null;
	}

	public class Node {
		private E data;
		private Node left;
		private Node right;

		public Node(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public boolean add(E item) {
		if (root == null) {
			root = new Node(item);
			return true;
		} 
		else {
			return add(root, item);
		}
	}

	private boolean add(Node node, E item) {
        if (item.equals(node.data)) {
            return false; // already in the tree
        } else if (item.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node(item);
                return true;
            } else {
                return add(node.left, item);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(item);
                return true;
            } else {
                return add(node.right, item);
                }
            }
        }
	
	public boolean find(E item) {
	    return find(root, item);
	}
        
	private boolean find(Node node, E item) {
		if (node == null) {
			return false; // item not found
		}
		else if (item.equals(node.data)) {
			return true;
		}
		else if (item.compareTo(node.data) < 0) {
			return find(node.left, item);
		}
		else {
			return find(node.right, item);
		}
	}

	public boolean remove(E item) {
        if (root == null) {
            return false; // empty tree
        } else if (item.equals(root.data)) {
            Node auxRoot = new Node(null);
            auxRoot.left = root;
            boolean result = remove(root, auxRoot, item);
            root = auxRoot.left;
            return result;
        } else {
            return remove(root, null, item);
        }
    }

    private boolean remove(Node node, Node parent, E item) {
        if (node == null) {
            return false; // item not found
        } else if (item.equals(node.data)) {
            if (node.left == null || node.right == null) {
                // case 1: node has at most one child
                Node child = node.left != null ? node.left : node.right;
                if (node == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            } else {
                // case 2: node has two children
                Node minNode = findMin(node.right);
                node.data = minNode.data;
                remove(node.right, node, minNode.data);
            }
            return true;
        } else if (item.compareTo(node.data) < 0) {
            return remove(node.left, node, item);
        } else {
            return remove(node.right, node, item);
        }
    }
	
    private Node findMin(Node node) {
        // helper method to find the minimum node in a subtree
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
	public Node getParent(E item) {
        return getParent(root, item);
    }

    private Node getParent(Node node, E item) {
        if (node == null || node.data.equals(item)) {
            return null;
        } else if ((node.left != null && node.left.data.equals(item)) || (node.right != null && node.right.data.equals(item))) {
            return node;
        } else if (item.compareTo(node.data) < 0) {
            return getParent(node.left, item);
        } else {
            return getParent(node.right, item);
        }
    }


	public ArrayList<E> getAllDescendant(E item) {
	    
        Node node = getItemNode(root, item);
        
        getAllDescendant(node);
        
        allDescendant.remove(item);
        
        return allDescendant; 
	}
	
	private void getAllDescendant(Node node) {
	    if (node == null) {
            return;
        }
	    getAllDescendant(node.left);
        allDescendant.add(node.data);
        getAllDescendant(node.right);
	    
	}
	
	//Helper method for getAllDescendant to get the
	//node of the item.
	private Node getItemNode(Node node, E item){
	    if (node == null) {
            return null; // item not found
        }
	    else if (item.equals(node.data)) {
            return node;
        }
	    else if (item.compareTo(node.data) < 0) {
            return getItemNode(node.left, item);
        }
        else {
            return getItemNode(node.right, item);
        }
	    
	}
	

	public Node getMax(Node node) {
	    if (node.right == null) {
	        return node;
	    }
	    
	    node = node.right;
	    return getMax(node);
	}
	
	public Node getMax() {
	    // automatically pass the root if no argument is given
	    return getMax(root);
	}

	public int getHeight(Node n) {
		if (n == null) {
			return 0;
		}
		else {
			// get the height of each subtree
			int leftHeight = getHeight(n.left);
			int rightHeight = getHeight(n.right);
			// use the larger of the two subtrees
			if (leftHeight > rightHeight) {
				return (leftHeight + 1);
			}
			else {
				return (rightHeight + 1);
			}
		}
	}
	
	public int getHeight() {
		// automatically pass the root if no argument is given
		return getHeight(root);
	}
	
	public int getLevel(E item) {
	    indidualNodeLevel = 1;
	    getLevel(root, item);
	    
	    return indidualNodeLevel;
    }
	
	private Node getLevel(Node node, E item) {
	    if (node == null) {
            return null; // item not found
        }
        else if (item.equals(node.data)) {
            return node;
        }
        else if (item.compareTo(node.data) < 0) {
            indidualNodeLevel++;
            return getLevel(node.left, item);
        }
        else {
            indidualNodeLevel++;
            return getLevel(node.right, item);
        }
	    
	}

	
	void addCurrentLevel(Node n, int level) {
		if (n == null) {
			return;
		}
		if (level == 1) {
			bfs.add(n.data);
		}
		else if (level > 1) {
			addCurrentLevel(n.left, level - 1);
			addCurrentLevel(n.right, level -1);
		}
	}

	
	void inOrder(Node n) {
		if (n == null) {
			return;
		}
		inOrder(n.left);
		System.out.print(n.data + " ");
		inOrder(n.right);
	}
	
	void inOrder() {
		// automatically pass the root if no argument is given
		inOrder(root);
	}

	void preOrder(Node n) {

		if (n == null) {
			return;
		}
		System.out.print(n.data + " ");
		preOrder(n.left);
		preOrder(n.right);
	}
	
	
	void preOrder() {
		// automatically pass the root if no argument is given
		preOrder(root);
	}
	

	void postOrder(Node n) {
		if (n == null) {
			return;
		}
		postOrder(n.left);
		postOrder(n.right);
		System.out.print(n.data + " ");
	}
	
	
	void postOrder() {
		// automatically pass the root if no argument is given
		postOrder(root);
	}
	

	ArrayList<E> bfs() {
		int h = getHeight(root);
		for (int i = 1; i <= h; i++) {
			addCurrentLevel(root, i);
		}
		return bfs;
	}
	

	public boolean isIdentical(Node anotherTree) {
		return false;
	}
	

	public int numLeaves(Node node) {

		if (node == null) {
			return 0;
		} else if ((node.left == null) && (node.right == null)) {
			return 1;
		}

		return numLeaves(node.left) + numLeaves(node.right);
	}
	
	public boolean isIdentical(BinarySearchTree<E> tree2, Node root, Node root2) {
       
        
        if (this.root == null && tree2.root == null) {
            return true;
        }
        
        if (root != null && root2 != null) {
            if (root.data != root2.data) {
                return false;
            }
            isIdentical(tree2, root.left, root2.left);
            isIdentical(tree2, root.right, root2.right);
        }
        return true;
    }
    
    public boolean isIdentical(BinarySearchTree<E> tree2) {
        return isIdentical(tree2, this.root, tree2.root);
    }
	
    public int numLeaves(Node root) {
        if (root == null) {
            return 0;
        
        } else if (root != null && (root.left == null) && (root.right == null)) {
            return 1;
        }

        return numLeaves(root.left) + numLeaves(root.right);
    }
    
    public int numLeaves() {
        return numLeaves(this.root);
    }
    
    public int numInternal(Node root) {
        
        int internalCount = 0;
        
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        
        else if (root.left != null && root.right != null) {
            internalCount++;
        }
        
        internalCount += (numInternal(root.right) + numInternal(root.left));
        

    return internalCount;
    
  }
    
    public int numInternal() {
        return numInternal(this.root);
    }
    
    public void clear(Node root) {

        if (root != null) {
            clear(root.left);
            clear(root.right);
            root.left = null;
            root.right = null;
            this.root = null;
        }


    }
    
    public void clear () {
        clear(this.root);
    }
	

	public static void main(String[] args) {
	    //Liban Testing methods
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();

		// add some nodes to the tree
		tree.add(5);
		tree.add(3);
		tree.add(7);
		tree.add(1);
		tree.add(4);
		tree.add(6);
		tree.add(9);

		// test the find() method
		System.out.println(tree.find(6)); // true
		System.out.println(tree.find(8)); // false
		// test the remove() method
		System.out.println(tree.remove(6)); // true
		System.out.println(tree.find(6)); // false

		//test the getParent() method
        BinarySearchTree.Node parent = tree.getParent(4);
        System.out.println(parent.data); // 3

        parent = tree.getParent(7);
        System.out.println(parent.data); // 5
		
        
        //Will Testing Methods
		// test the inOrder() method
		System.out.print("Inorder traversal of tree: ");
		tree.inOrder();
		System.out.println();
		// test the preOrder() method
		System.out.print("Preorder traversal of tree: ");
		tree.preOrder();
		System.out.println();
		// test the postOrder() method
		System.out.print("Postorder traversal of tree: ");
		tree.postOrder();
		System.out.println();
		// test the bfs() method
		System.out.print("BFS traversal of tree: ");
		ArrayList test = tree.bfs();
		for (int i = 0; i < test.size(); i++) {
			System.out.print(test.get(i) + " ");
		}
		
		
		//Ahmad Testing methods
		System.out.println();
		
		//Testing getHeight
		System.out.println("Height of tree: " + tree.getHeight());
		
		//Testing get Max method
		System.out.println("Max Value of Tree: " + tree.getMax().data); //should be 9
		
		//Testing getAllDescendant method
		System.out.println("All Descendants of "
		        + "node with item 3: " + tree.getAllDescendant(3)); // should be [1,4]
		
		//Testing get all level method
		System.out.println("Level of Node with item 4: " + tree.getLevel(4)); //should be 3
		
		
		//Bens testing last 4 methods
        BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();

        // add some nodes to the tree
        tree2.add(5);
        tree2.add(3);
        tree2.add(7);
        tree2.add(1);
        tree2.add(4);
        tree2.add(6);
        tree2.add(9);
        
        
        System.out.println(tree.isIdentical(tree2));
        
        System.out.println("internal nodes : " + tree.numInternal());
        System.out.println("leaf nodes : " + tree.numLeaves());
        
        tree.clear();
        System.out.println("internal nodes after clear : " + tree.numInternal());
        System.out.println("leaf nodes after clear : " + tree.numLeaves());
        System.out.println("root after clear : " + tree.root);
	}

}
