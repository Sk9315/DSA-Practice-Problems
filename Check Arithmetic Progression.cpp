/*
Given an array arr[] of integers. Write a program to check whether an arithmetic progression can be formed using all the given elements. 

Examples:

Input: arr[] = [0, 12, 4, 8]
Output: true
Explanation: Rearrange given array as [0, 4, 8, 12] which forms an arithmetic progression.
Input: arr[] = [12, 40, 11, 20]
Output: false
Explanation: there is no rearrangment which can forms an arithmetic progression.
Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106


*/


#include <bits/stdc++.h>
using namespace std;
class Solution {
  public:
    bool checkIsAP(vector<int> &arr) {
        // Your code goes here
        
        sort(arr.begin(),arr.end());
        int n=arr.size();
         int cd=arr[1]-arr[0];
        for(int i=0;i<n-1;++i){
            if((arr[i+1]-arr[i])!=cd){
                return false;
            }
        }
        return true;
    }
};