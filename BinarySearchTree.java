public class BinarySearchTree<E extends Comparable<E>> {

    private Node root;

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
        } else {
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
        public boolean find(E item) {
        return find(root, item);
    }

    private boolean find(Node node, E item) {
        if (node == null) {
            return false; // item not found
        } else if (item.equals(node.data)) {
            return true;
        } else if (item.compareTo(node.data) < 0) {
            return find(node.left, item);
        } else {
            return find(node.right, item);
        }}
        public Node getParent(E item) {
            return getParent(root, item);
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
    	//helper method to find the minimium node in a subtree
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    }
 public static void main(String[] args) {
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
            //test the remove() method
            System.out.println(tree.remove(6)); // true
            System.out.println(tree.find(6)); // false
