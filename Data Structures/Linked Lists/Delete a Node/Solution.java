/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list
 */

Node Delete(Node head, int position) {
    if (head == null) {
        return null;
    } else if (position == 0) {
        return head.next;
    } else {
        Node node = head;
        for (int i = 0; i < position - 1; i++) {
            node = node.next;
        }
        
        node.next = node.next.next;
    }
    
    return head;
}