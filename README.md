# Lab-6-BinarySearchTree

1. add(E item) boolean (Liban)
2. remove(E item) E (Liban)
3. find (E item) boolean (Liban)
4. getParent(E item): E (Liban)
5. getAllDescendant (E item): ArrayList<E> (Ahmad)
6. getMax(): E (Ahmad)
7. getHeight(): int (Ahmad)
8. getLevel(E item): int (Ahmad)
9. inOrder(): void (Will)
10. preOrder(): void (Will)
11. postOrder(): void (Will)
12. bfs(): ArrayList<E> (Will)
13. isIdentical(Node<E> anotherTree) (Ben)
14. numLeaves(): int (Ben)
15. numInternal(): int (Ben)
16. clear(): void (Ben)
  
Make sure you create a test cases in the main method to test out your methods.
  
Each method should have the name of the developer, the order of the
method, and justification for the order on top of it. In cases that you need
another method implemented by the other teammate, ask them to push it to
the repo and pull it then.
  
  
implementation:
  Create a node that has 3 data feilds, one for the data, one for the left pointer,
  and one for the right pointer. Whithin the tree class there will also be a feild 
  called root pointing to the highest node.
  
  Make sure to make method recursive if possible.
