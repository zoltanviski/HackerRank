/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle
 */

boolean hasCycle(Node head) {
    if (head == null) return false;
    
    Node node = head;
    Map<Node,Boolean> checkedMap = new HashMap<Node,Boolean>();  
    
    while (node != null) {
        if (checkedMap.containsKey(node)) return true;
        
        checkedMap.put(node, true);
        
        node = node.next;
    }
    
    return false;
}