/*
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
import java.util.*;

class Solution {

    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        // Map: pos -> list of nodes
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // BFS queues
        Deque<Node> nod = new ArrayDeque<>();
        Deque<Integer> index = new ArrayDeque<>();

        nod.offer(root);
        index.offer(0);

        int min = 0, max = 0;

        while (!nod.isEmpty()) {
            Node temp = nod.poll();
            int pos = index.poll();

            // insert into map
            map.putIfAbsent(pos, new ArrayList<>());
            map.get(pos).add(temp.data);

            // update range
            min = Math.min(min, pos);
            max = Math.max(max, pos);

            // BFS traversal
            if (temp.left != null) {
                nod.offer(temp.left);
                index.offer(pos - 1);
            }

            if (temp.right != null) {
                nod.offer(temp.right);
                index.offer(pos + 1);
            }
        }

        // build answer from min → max
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}