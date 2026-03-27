/*
Given an array arr[] of integers, for each element in the array, find the nearest smaller element on its left. If there is no such smaller element, return -1 for that position.

Input: arr[] = [1, 6, 2]
Output: [-1, 1, 1]
Explaination: 
There is no number to the left of 1, so we return -1. 
After that, the number is 6, and the nearest smaller number on its left is 1. 
Next, the number is 2, and the nearest smaller number on the left is also 1.
Input: arr[] = [1, 5, 0, 3, 4, 5]
Output: [-1, 1, -1, 0, 3, 4]
Explaination: 
There is no number to the left of 1,  so we return -1. 
After that, the number is 5,  and the nearest smaller number on its left is 1. 
 Next, the number is 0, and there is no smaller number on the left, so we return -1.
Then comes 3, and the nearest smaller number on its left is 0.
After that, the number is 4, and the nearest smaller number on the left is 3. 
Finally, the number is 5, and the nearest smaller number on its left is 4.
Constraints:
1 ≤ arr.size()≤ 106
1 ≤ arr[i] ≤ 103 

Expected Complexities
Topic Tags
StackData Structures

*/
import java.util.*;
class Solution {
    public int[] leftSmaller(int[] arr) {
        int n=arr.length;
       int[] result = new int[n];
        Arrays.fill(result, -1);
        
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            
            // Remove all elements >= current
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            
            // Top will be the answer
            if (!st.isEmpty()) {
                result[i] = st.peek();
            }
            
            // Push current element
            st.push(arr[i]);
        }
        
        return result;
    }
}
