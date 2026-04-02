/*
Given a binary tree. Find the postorder traversal of the tree without using recursion. Return a list containing the postorder traversal of the tree, calculated without using recursion.

Examples :

Input:
           1
         /   \
        2     3
      /  \
     4    5

Output: 4 5 2 3 1
Explanation: Postorder traversal (Left->Right->Root) of the tree is 4 5 2 3 1.
Input:
             8
          /      \
        1          5
         \       /   \
          7     10    6
           \   /
            10 6

Output: 10 7 1 6 10 6 5 8 
Explanation: Postorder traversal (Left->Right->Root) of the tree is 10 7 1 6 10 6 5 8 .
 
Expected time complexity: O(n)
Expected auxiliary space: O(n)
 
Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105
Expected Complexities
Company Tags
Microsoft
*/
import java.util.*;
// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Tree {
    ArrayList<Integer> postOrder(Node node) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        while(node!=null){
            if(node.right==null){
                ans.add(node.data);
                node=node.left;
            }
            else{
                Node temp=node.right;
                //go to the left most node and make connection if not there
                while(temp.left!=null&&temp.left!=node){
                    temp=temp.left;
                }
                if(temp.left==null){
                    ans.add(node.data);
                    temp.left=node;
                    node=node.right;
                    
                }
                else{
                    temp.left=null;
                    node=node.left;
                }
            }
            
        }
    
        Collections.reverse(ans);
        return ans;
    }
}