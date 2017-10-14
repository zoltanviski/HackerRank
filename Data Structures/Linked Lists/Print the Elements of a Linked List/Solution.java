/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list
 */

void Print(Node head) {
  
    if (head == null) return;
    
    Node node = head;
    System.out.println(node.data);
    
    while (node.next != null)
    {
        node = node.next;
        System.out.println(node.data);
    } 
}