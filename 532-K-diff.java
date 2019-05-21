/**
Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. 
Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their
 absolute difference is k.

居然考的是数学知识
两个集合的交集


**/



class Solution {
    public int findPairs(int[] nums, int k) 
    {
       int ans = 0;
        
        if( k<0 )  return ans;
        
        Set<Integer> set1 = new HashSet<Integer> ();
        Set<Integer> set2 = new HashSet<Integer> ();
        
        if(k==0)
        {
            for(int n:nums)
            {
                if(!set1.contains(n))
                {set1.add(n);}
                else{
                    if(!set2.contains(n)) ans++;
                    set2.add(n);
                }
            }
        }
        else{
            for(int n : nums)
            {
                set1.add(n);
                set2.add(n+k);
            }
            set1.retainAll(set2);
            ans = set1.size();
        }
        
        return ans;
    }
}