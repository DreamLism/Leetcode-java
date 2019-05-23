/**
Given an array with n integers, your task is to check if it could become non-decreasing 
by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds 
for every i (1 <= i < n).


Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

**/

//有点难度
class Solution 
{
     public boolean checkPossibility(int[] nums) 
     {
         if(nums == null || nums.length <= 1) return true;
         boolean found = false;
         for(int i =1; i<nums.length;i++)
         {
             if(nums[i]<nums[i-1])
             {
                 if(found) return false;
                 else{
                     if(i-2>=0 && nums[i]<nums[i-2]) nums[i] = nums[i-1];    //边界解决
                     found = true;
                 }
             }
         }
         return true;
     }
}


/**
Given: a1, a2, a3, a4, a5, ...

Suppose a4<a3, we must modify either a3 or a4, the goal is to make a1...a4 satisfy 
the conditions and a4 has a relative small value.

if a4<a2, then we have to modify a4, and the best choice is to let a4 = a3;
otherwise, it's better to modify a3 to let a3 = a4 (no change to a4);

**/