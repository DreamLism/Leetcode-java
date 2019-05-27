Description:
/**

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
开始刷题

**/


Code:

class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ret = new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                ret[0] = map.get(target-nums[i]);
                ret[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return ret;   
    }
}
