/**
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
**/



//题目难点主要在于对元音字符的存储

法一:用set集合存储

public class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (!set.contains(arr[left])) {
                left++;
            } else if (!set.contains(arr[right])) {
                right--;
            } else {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}


//利用string的索引查询
class Solution {
    public String reverseVowels(String s) 
    {
        int i = 0, j = s.length() - 1;
        char[] arr = s.toCharArray();     //字符串转数组
        String vowels = "aeiouAEIOU";
        while(i < j) 
        {
            while(i < j && vowels.indexOf(arr[i]) == -1)   //字符串索引,非元音字符
            {
                i++;
            }
            while(i < j && vowels.indexOf(arr[j]) == -1)   //非元音字符
            {
                j--;
            }
            if(i < j) 
            {
                char tmp = '0';
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}