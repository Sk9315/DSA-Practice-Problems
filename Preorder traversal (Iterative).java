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
Time Complexity: O(n)
Auxiliary Space: O(1)
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
        Stack<Node>st=new Stack<>();
        ArrayList<Integer>ans=new ArrayList<>();
        st.push(root);
        while(!st.isEmpty()){
            ans.add(st.peek().data);
            Node temp=st.peek();
            st.pop();
            if(temp.right!=null){
                st.push(temp.right);
            }
            if(temp.left!=null){
                st.push(temp.left);
            }
        }
        return ans;
    }
}