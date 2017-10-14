/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/tree-preorder-traversal
 */

void preOrder(Node root) {
    if (root != null) {
        System.out.print(root.data + " ");
        
        preOrder(root.left);
        preOrder(root.right);
    }
}