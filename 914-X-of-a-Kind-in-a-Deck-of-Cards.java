/**
In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.
 

Example 1:

Input: [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]


**/
法一:容易理解，同时更好学习集合类

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length <= 1) return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < deck.length; i++){
            if(!map.containsKey(deck[i])){
                map.put(deck[i],1);
            }
            else{
                map.put(deck[i],map.get(deck[i])+1);
            }
        }
        int myGcd = (int)map.values().toArray()[0];     //集合转数组，获取第一个元素
        for(Integer myKeys : map.keySet())              //遍历
        {
            myGcd = gcd(myGcd,map.get(myKeys));
        }
        if(myGcd == 1){
            return false;
        }
        else{
            return true;
        }
    }
        static int gcd(int a, int b)                    //求最大公约数
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 
    
}


法二:大佬代码，又快又简单，日常一跪
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);
        for (int i : count.values()) res = gcd(i, res);
        return res > 1;
    }

    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}