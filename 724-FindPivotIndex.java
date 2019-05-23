/**
Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:

Input: 
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation: 
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.

**/

//法一:容易理解，但是太慢了。越界问题还是要处理好
class Solution {
    public int pivotIndex(int[] nums) 
    {
        int sumLeft;
        int sumRight;
        
        if(nums.length<1)
        {
            return -1;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            sumLeft = leftSum(i,nums);
            sumRight = rightSum(i,nums);
            
            if(sumLeft == sumRight)
            {
                return i;
            }
        }
        
        return -1;       
    }
    
    public int leftSum(int i,int[] nums)
    {
        int sum = 0;
        for(int k =i-1; k>=0;k--)
        {
            sum += nums[k];
        }
        return sum;
    }
    
    public int rightSum(int i,int[] nums)
    {
        int sum = 0;
        for(int k =i+1;k<nums.length;k++)
        {
            sum += nums[k];
        }
        return sum;
    }
    
    
    
}



//又快又简单

class Solution {
    public int pivotIndex(int[] nums) 
    {
        int total = 0,sum=0;
        for(int num : nums) total += num;
        for(int i=0;i<nums.length;sum+=nums[i++])
            if(sum*2 == total - nums[i])  return i;
        return -1;
    }
}