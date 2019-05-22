/**
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
**/


//法一:复制数组比较，看的答案，时空消耗有点多

public int findUnsortedSubarray(int[] nums) {
    int[] nums_sorted = Arrays.copyOf(nums, nums.length);
    Arrays.sort(nums_sorted);
        
    int i = 0, j = nums.length - 1;
        
    while (i < nums.length && nums[i] == nums_sorted[i]) i++;
    while (i < j && nums[j] == nums_sorted[j]) j--;
        
    return j - i + 1;
}



//法二：从两边分别找有序数组，则中间的就是无序子序列，开始想到的方法，实现起来没有过全部case,边界处理有点问题。
//参考了大佬的答案才发现少考虑了一条 nums[i - 1] <= min and max <= nums[j + 1] 即中间部分可能比两边小或大。
//这个时候就需要回退了。

public int findUnsortedSubarray(int[] nums) {
    int l = 0, r = nums.length - 1;
    
    while (l < r && nums[l] <= nums[l + 1]) l++;
        
    if (l >= r) return 0;
    
    while (nums[r] >= nums[r - 1]) r--;
    
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
    for (int k = l; k <= r; k++) {
        max = Math.max(max, nums[k]);
        min = Math.min(min, nums[k]);
    }
    
    while (l >= 0 && min < nums[l]) l--;
    while (r < nums.length && nums[r] < max) r++;
        
    return (r - l - 1);
}