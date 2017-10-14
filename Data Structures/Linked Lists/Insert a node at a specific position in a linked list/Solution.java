/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
 */

Node InsertNth(Node head, int data, int position) {
    Node dummy = new Node();
    dummy.next = head;
    
    Node runner = dummy;
    for (int i = 0; i < position; i++) {
        runner = runner.next;
    }
    
    Node newNode = new Node();
    newNode.data = data;
    newNode.next = runner.next;
    runner.next = newNode;
    
    return dummy.next;
}