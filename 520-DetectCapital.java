/**
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

1.All letters in this word are capitals, like "USA".
2.All letters in this word are not capitals, like "leetcode".
3.Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 

Example 1:

Input: "USA"
Output: True

**/

//法一:  最精彩的在于判断语句，还是集合思想以及一些java封装类的使用
class Solution 
{
    public boolean detectCapitalUse(String word) 
    {
        int upper, lower;
        upper = lower = 0;
        if (word.length()<2) return true;
        for (int i=0; i<word.length(); i++) 
        {
            if (Character.isUpperCase(word.charAt(i)))       //Java Character 类
            {
                upper++;
            }
            else lower++;
        }
        if (upper == word.length() || lower == word.length() || (upper == 1 && Character.isUpperCase(word.charAt(0))))    //对于大写字母的判断
            return true;
        return false;
    }
}


//法二:没有用一些内置的函数，类
class Solution {
    public boolean detectCapitalUse(String word) 
    {
      if(word == null || word.length() == 0) return false;
      int sign = 0;
      if(word.charAt(0) >= 'a' && word.charAt(0) <= 'z')
      {
          sign = 2;                         //用来一个标志位
      }
      for(int i=1;i<word.length();i++)
      {
          if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
          {
              if(sign == 2)
                  return false;
              sign = 1;
          }
          else if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')
          {
              if(sign == 1)
                  return false;
              sign = 2;
          }
      }
        return true;
    }
}

//法三:用了java内置的一些东西
class Solution {
    public boolean detectCapitalUse(String word) 
    {
      if(word.length() < 2)  return true;
      if(word.toUpperCase().equals(word))  return true;
      if(word.substring(1).toLowerCase().equals(word.substring(1)))  return true;
      return false;
    }
}
