/*
Vertical Tree Traversal
Difficulty: MediumAccuracy: 32.87%Submissions: 234K+Points: 4Average Time: 45m
Given the root of a Binary Tree, find the vertical traversal of the tree starting from the leftmost level to the rightmost level.

Note: If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.

Examples:

Input: root = [1, 2, 3, 4, 5, 6, 7, N, N, N, 8, N, 9, N, 10, 11, N]
                    
Output: [[4], [2], [1, 5, 6, 11], [3, 8, 9], [7], [10]]
Explanation: The below image shows the horizontal distances used to print vertical traversal starting from the leftmost level to the rightmost level.
     
Input: root = [1, 2, 3, 4, 5, N, 6]
     
Output: [[4], [2], [1, 5], [3], [6]]
Explanation: From left to right the vertical order will be [[4], [2], [1, 5], [3], [6]]
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

Expected Complexities
Company Tags
FlipkartAccoliteAmazonMicrosoftMakeMyTripWalmartBrowserStackDellGrofersNetskope
*/

import java.util.*;
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    int left = 0;
    int right = 0;

    public void find(Node root, int pos){
        if(root == null) return;

        left = Math.min(left, pos);
        right = Math.max(right, pos);

        find(root.left, pos - 1);
        find(root.right, pos + 1);
    }

    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        // Step 1: find range
        find(root, 0);

        // Step 2: create buckets
        ArrayList<ArrayList<Integer>> positive = new ArrayList<>();
        ArrayList<ArrayList<Integer>> negative = new ArrayList<>();

        for (int i = 0; i <= right; i++) {
            positive.add(new ArrayList<>());
        }

        for (int i = 0; i <= Math.abs(left); i++) {
            negative.add(new ArrayList<>());
        }

        // Step 3: BFS
        Deque<Node> nod = new ArrayDeque<>();
        Deque<Integer> index = new ArrayDeque<>();

        nod.offer(root);
        index.offer(0);

        while(!nod.isEmpty()){
            Node temp = nod.poll();
            int pos = index.poll();

            if(pos >= 0){
                positive.get(pos).add(temp.data);
            } else {
                negative.get(Math.abs(pos)).add(temp.data);
            }

            if(temp.left != null){
                nod.offer(temp.left);
                index.offer(pos - 1);
            }

            if(temp.right != null){
                nod.offer(temp.right);
                index.offer(pos + 1);
            }
        }

        // Step 4: build answer
        for(int i = negative.size() - 1; i > 0; i--){
            ans.add(negative.get(i));
        }

        for(int i = 0; i < positive.size(); i++){
            ans.add(positive.get(i));
        }

        return ans;
    }
}