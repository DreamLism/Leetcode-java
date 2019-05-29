/**
You are given a string representing an attendance record for a student. The record only contains the following three characters:
1.'A' : Absent.
2.'L' : Late.
3.'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True

**/

//法一:            //直接匹配，耗时较长

class Solution{
public boolean checkRecord(String s) 
{
    return !s.matches(".*LLL.*|.*A.*A.*");
    }
}


//法二:
  public class Solution {
    public boolean checkRecord(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))   //前者是返回第一次出现位置，后者是返回最后一次出现位置
            return false;
        return true;
    }
}


//法三:
class Solution {
    public boolean checkRecord(String s) 
    {
        //超过一个A或多于两个连续L
        int countA = 0;
        int continuosL = 0;
        int charA = 'A';
        int charL = 'L';
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == charA)
            {
                countA++;
                continuosL = 0;
            }
            else if(s.charAt(i) == charL)
            {
                continuosL++;                 //对于连续性字符的统计
            }
            else{
                continuosL = 0;
            }
            if(countA > 1 || continuosL > 2)
            {
                return false;   //直接退出函数
            }
        }
        return true;
    }
}