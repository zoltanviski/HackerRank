/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list
 */

Node Insert(Node head,int data) {
    Node node = head;
    
    while (node.next != null) {
        node = node.next;
    }
    
    Node tailNode = new Node();
    tailNode.data = data;
    
    node.next = tailNode;
    
    return head;
}
