/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/tree-postorder-traversal/problem
 */

void postOrder(Node root) {
    if (root == null) return;
    
    postOrder(root.left);
    postOrder(root.right);
    
    System.out.printf("%d ", root.data);
}