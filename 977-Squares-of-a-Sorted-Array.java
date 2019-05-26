/**
Given an array of integers A sorted in non-decreasing order, 
return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

**/


//法一:常规
class Solution {
    public int[] sortedSquares(int[] A) 
    {
        int len = A.length;
        for(int i=0;i<len;i++)
        {
            A[i] = A[i]*A[i];
        }
        
        Arrays.sort(A);     //排序时间消耗有点大
        return A;
        
    }
}


//法二:空间换时间
class Solution {
    public int[] sortedSquares(int[] A) {
        int i = 0, j = A.length -1, k=j;
        int[] B = new int[A.length];
        while(k>=0){
            int x = A[i]*A[i], y = A[j]*A[j];
            if(x >= y){
                B[k] = x;
                i++;
            } else{
                B[k] = y;
                j--;
            }
			k--;
        }
        return B;
    }
}