/*
Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
   
Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:
   
Input: head = 2 → 2 → 0 → 1
   
Output: 0 → 1 → 2 → 2
Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be:
   
Constraints:
1 ≤ no. of nodes ≤ 106
0 ≤ node->data ≤ 2

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)
Company Tags
AmazonMicrosoftMakeMyTripNPCI

*/
import java.util.*;
/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/
class Solution {
    public Node segregate(Node head) {
        Node ans = new Node(0);
        Node temp = ans;

        for (int i = 0; i < 3; i++) {
            Node curr = head;
            while (curr != null) {
                if (curr.data == i) {
                    temp.next = new Node(i);
                    temp = temp.next;
                }
                curr = curr.next;
            }
        }
        return ans.next;
    }
}