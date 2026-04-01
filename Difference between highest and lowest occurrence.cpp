/*
Given an array, the task is to find the difference between the highest occurrence and lowest occurrence of any number in an array.
Note: If only one type of element is present in the array return 0

Examples:

Input: arr[] = [1, 2, 2]
Output: 1
Explanation:  Lowest occurring element (1) occurs once. Highest occurring element (2) occurs 2 times
Input: arr[] = [7, 8, 4, 5, 4, 1, 1, 7, 7, 2, 5]
Output: 2
Explanation : Lowest occurring element (2) occurs once. Highest occurring element (7) occurs 3 times
Constraints:
1<= arr.size() <=106
1<= arr[i] <=106

*/

#include <bits/stdc++.h>
using namespace std;

Courses
Tutorials
Practice
Jobs

avatar


Refresh

Time (IST)	Status	Marks	Lang	Test Cases	Code
2025-06-18 20:58:58	Correct	
1
cpp	1115 / 1115	View
C++ (17)



        



Custom Input
class Solution {
  public:
    // Function to find the difference between the maximum and minimum frequency of elements.
    int findDiff(vector<int>& arr) {
        unordered_map<int, int> map;
        int n = arr.size();

        // Count the frequency of each element
        for (int i = 0; i < n; ++i) {
            if (map.find(arr[i]) != map.end()) {
                map[arr[i]] += 1;
            }
            else {
                map[arr[i]] = 1;
            }
        }

        int maxs = 0;
        int mins = INT_MAX;

       
         for (auto it = map.begin(); it != map.end(); ++it) {
            int freq = it->second;
            if (freq > maxs) {
                maxs = freq;
            }
            if (freq < mins) {
                mins = freq;
            }
        }

        return maxs - mins;
    }
};