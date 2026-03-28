/*
Levelorder traversal of a BST


*/
import java.util.*;
class Solution {
    // Function to return the level order traversal of a BST.
    static ArrayList<Integer> levelOrder(Node node) {
        // code here
        // code here
        Deque<Node> dq = new ArrayDeque<>();
        ArrayList<Integer>al=new ArrayList<>();
        dq.offer(node);
        Node temp=null;
        while(!dq.isEmpty()){
            temp=dq.peek();
            al.add(temp.data);
            if(temp.left!=null){
                dq.offer(temp.left);
            }
            if(temp.right!=null){
                dq.offer(temp.right);
            }
            dq.poll();
            
        }
        return al;
        
    }
}