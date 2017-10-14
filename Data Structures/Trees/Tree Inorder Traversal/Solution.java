/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/tree-inorder-traversal
 */

void inOrder(Node root) {
    if (root == null) return;
    
    inOrder(root.left);
    
    System.out.print(root.data + " ");
    
    inOrder(root.right);
}