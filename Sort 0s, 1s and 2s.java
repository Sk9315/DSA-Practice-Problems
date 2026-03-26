/*
Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
Note: You need to solve this problem without utilizing the built-in sort function.

Examples:

Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s, 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s, 1s and 2s are segregated into ascending order.
Follow up: Could you come up with a one-pass algorithm using only constant extra space?

Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 2

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)
Company Tags
PaytmFlipkartMorgan StanleyAmazonMicrosoftOYO RoomsSamsungSnapdealHikeMakeMyTripOla CabsWalmartMAQ SoftwareAdobeYatra.comSAP LabsQualcomm
Topic Tags

*/
import java.util.*;
class Solution {
    public void sort012(int[] arr) {
        // code here
        int n=arr.length;
        int zero=0,one=0,two=0;
        for(int i=0;i<n;++i){
            if(arr[i]==0){
                zero++;
            }
            else if(arr[i]==1){
                one++;
            }
            else{
                two++;
            }
        }
        int x=0;
        int y=0;
        for(int i=0;i<n;++i){
            if(i<zero){
                arr[i]=0;
                x++;
                y++;
            }
            else if(i<(x+one)){
                y++;
                 arr[i]=1;
            }
            else{
                arr[i]=2;
            }
        }
    }
}
