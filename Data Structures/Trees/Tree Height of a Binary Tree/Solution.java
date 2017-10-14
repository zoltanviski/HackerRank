/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
 */

static int height(Node root) {
	int leftHeight = 0;
	int rightHeight = 0;

	if (root.left != null) {
		leftHeight = 1 + height(root.left);
	}

	if (root.right != null) {
		rightHeight = 1 + height(root.right);
	}

	return leftHeight > rightHeight ? leftHeight : rightHeight;
}