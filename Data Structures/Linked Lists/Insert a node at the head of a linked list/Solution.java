/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list
 */

Node Insert(Node head,int x) {
    Node newHead = new Node();
    newHead.data = x;
    newHead.next = head;
    
    return newHead;
}
