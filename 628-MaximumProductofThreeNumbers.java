/**
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:

Input: [1,2,3]
Output: 6


**/

//法一:挺容易想到，但是需要排序，时间慢了点-----------插入->快排->归并
class Solution {
    public int maximumProduct(int[] nums) 
    {
        //三个最大乘积,有负数
        Arrays.sort(nums);
        int len = nums.length-1;
        if((nums[0] * nums[1] * nums[len]) > (nums[len-2] * nums[len-1] * nums[len]))
            return nums[0] * nums[1] * nums[len];
        
        return nums[len-2] * nums[len-1] * nums[len];   
        
    }
}


//法二:看的一个大神的，真的快
class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}