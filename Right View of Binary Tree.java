/*
Given the root of a binary Tree. Your task is to return the right view of the binary tree. The right view of a Binary Tree is the set of nodes visible when the tree is viewed from the right side.

Examples :

Input: root = [1, 2, 3, N, N, 4, 5]
     2_2
Output: [1, 3, 5]
Input: root = [1, 2, 3, 4, N, N, N, N, 5]
     Right-view-in-binary-tree-1
Output: [1, 3, 4, 5]
Constraints:
1 ≤ number of nodes ≤ 105
0 ≤ node->data ≤ 105

Expected Complexities
Company Tags
AccoliteAmazonSnapdealMakeMyTripAdobe
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
    public ArrayList<Integer> rightView(Node root) {
        // code here
          ArrayList<Integer>ans=new ArrayList<>();
        Deque<Node>dq1=new ArrayDeque<>();
        Deque<Node>dq2=new ArrayDeque<>();
        dq1.offer(root);
       while(!dq1.isEmpty() || !dq2.isEmpty()){
            if(!dq1.isEmpty()){
               int rv=Integer.MIN_VALUE;
                while(!dq1.isEmpty()){
                if(dq1.peek()!=null){
                        rv=dq1.peek().data;
                    }
                if(dq1.peek().left!=null){
                    dq2.offer(dq1.peek().left);
                }
                if(dq1.peek().right!=null){
                    dq2.offer(dq1.peek().right);
                }
                dq1.poll();
            }
            ans.add(rv);
        }
            
            if(!dq2.isEmpty()){
                int rv=Integer.MIN_VALUE;
                while(!dq2.isEmpty()){
                    if(dq2.peek()!=null){
                        rv=dq2.peek().data;
                    }
                if(dq2.peek().left!=null){
                    dq1.offer(dq2.peek().left);
                }
                if(dq2.peek().right!=null){
                    dq1.offer(dq2.peek().right);
                }
                dq2.poll();
            }
            ans.add(rv);
            
            }
        }
        return ans;
    }
}