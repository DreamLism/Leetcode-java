/**
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

**/

法一:

class Solution {
    public int[] sortArrayByParity(int[] A) 
    {
        int result[] = new int[A.length];      //开辟数组，增加空间消耗
        int start = 0;
        int end = A.length - 1;
        
        for(int i = 0;i < A.length;i++)
        {
            if(A[i]%2 == 0) result[start++] = A[i];
            else if(A[i]%2 ==1) result[end--] = A[i];
        }
        return result;
    }
}


法二:
class Solution {
    public int[] sortArrayByParity(int[] A) 
    {
        for(int i = 0,j = 0;j < A.length;j++)
            if(A[j]%2==0)
            {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;
            }
        return A;
    }
}