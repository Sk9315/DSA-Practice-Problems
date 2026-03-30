/*
Given the root of a binary tree. Your task is to return the left view of the binary tree. The left view of a binary tree is the set of nodes visible when the tree is viewed from the left side.

Note: If the tree is empty, return an empty list.

Examples :

Input: root = [1, 2, 3, 4, 5, N, N]

Output:[1, 2, 4]
Explanation: From the left side of the tree, only the nodes 1, 2, and 4 are visible.

Input: root = [1, 2, 3, N, N, 4, N, N, 5, N, N]

Output: [1, 2, 4, 5]
Explanation: From the left side of the tree, only the nodes 1, 2, 4, and 5 are visible.

Constraints:
0 ≤ number of nodes ≤ 105
0 ≤ node -> data ≤ 105

Expected Complexities
Company Tags
PaytmFlipkartAccoliteAmazonOYO RoomsSamsungSnapdealMakeMyTripOla CabsAdobeQualcommTwitterKnowlarityOpen SolutionsNPCI
*/
import java.util.*;
/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        Deque<Node>dq1=new ArrayDeque<>();
        Deque<Node>dq2=new ArrayDeque<>();
        dq1.offer(root);
       while(!dq1.isEmpty() || !dq2.isEmpty()){
            if(!dq1.isEmpty()){
                ans.add(dq1.peek().data);
                while(!dq1.isEmpty()){
                if(dq1.peek().left!=null){
                    dq2.offer(dq1.peek().left);
                }
                if(dq1.peek().right!=null){
                    dq2.offer(dq1.peek().right);
                }
                dq1.poll();
            }
        }
            
            if(!dq2.isEmpty()){
                ans.add(dq2.peek().data);
                while(!dq2.isEmpty()){
                
                if(dq2.peek().left!=null){
                    dq1.offer(dq2.peek().left);
                }
                if(dq2.peek().right!=null){
                    dq1.offer(dq2.peek().right);
                }
                dq2.poll();
            }
            }
        }
        return ans;
    }
}