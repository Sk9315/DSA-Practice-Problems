/*
Given a Binary tree. Find the preorder traversal of the tree without using recursion.

Follow up: Try solving this with O(1) auxiliary space.


Examples:

Input: root = [1, 2, 3, 4, 5]

Output: [1, 2, 4, 5, 3]
Explanation:
Preorder traversal (Root->Left->Right) of
the tree is 1 2 4 5 3.
Input: root = [8, 1, 5, N, 7, 10, 6, N, 10, 6]

Output: [8, 1, 7, 10, 5, 10, 6, 6] 
Explanation:
Preorder traversal (Root->Left->Right) 
of the tree is 8 1 7 10 5 10 6 6.
Constraints:
1 ≤ Number of nodes ≤ 105
0 ≤ node->data ≤ 105

Expected Complexities
Company Tags
MicrosoftNPCI

*/
import java.util.*;
/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> preOrder(Node root) {
        // code here
         ArrayList<Integer>ans=new ArrayList<>();
     while(root!=null){
         if(root.left==null){
             ans.add(root.data);
             root=root.right;
         }
         else{
             Node curr=root.left;
             while(curr.right!=null && curr.right!=root){
                 curr=curr.right;
             }
             
             if(curr.right==null){
                ans.add(root.data);
                curr.right=root;
                root=root.left;
             }
             else{
                 curr.right=null;
                 root=root.right;
             }
         }
     }
     return ans;
    }

}