/**
Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. 
And you need to output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75


**/



class Solution {
    public double findMaxAverage(int[] nums, int k) 
    {
        //连续K个值的平均值最大
        long sum = 0;
        for(int i = 0; i < k; i++)  sum += nums[i];
        long max = sum;
        
        for(int i = k;i < nums.length; i++)
        {
            sum += nums[i] - nums[i-k];
            max = Math.max(max,sum);
            
        }
        
        return max / 1.0 / k;
                 
    }
}