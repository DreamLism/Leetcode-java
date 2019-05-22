/**
Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True

**/


class Solution {
    public boolean canPlaceFlowers(int[] bed, int n) 
    {
        for(int i = 0; i < bed.length; i++)
        {
            if(bed[i] ==0 && (i==0 || bed[i-1] == 0) && (i == bed.length -1 || bed[i+1] == 0))   //难点在于考虑三个边界点，用了一个并集
            {
                bed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}