package com.leetcode.wing;


import java.util.HashSet;
import java.util.Set;


/**
 * @author qxs on 2018/7/9.
 * String 类型
 */
public class StringType {

    /**
     * 258_AddDigits
     */
    public int addDigits(int num) {
        return (num-1)%9+1;
    }

    /**
     * 371_SumOfTwoIntegers
     */
    int getSum(int a, int b) {
        if(b==0){
            return a;
        }
        int sum ,carry;
        sum = a^b;
        carry=(a&b)<<1;
        return getSum(sum,carry);
    }

    /**
     * 771.宝石与石头
     *  给定字符串J ，和字符串 S。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     *  J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     *  示例 1:
     *  输入: J = "aA", S = "aAAbbbb"
     *  输出: 3
     *  示例 2:
     *  输入: J = "z", S = "ZZ"
     *  输出: 0
     *  注意:
     *  S 和 J 最多含有50个字母。
     *  J 中的字符不重复。
     * @param J 代表石头中宝石的类型
     * @param S 代表你拥有的石头
     * @return 石头个数
     */
    private int numJewelsInStones(String J, String S) {
        Set<Character> jSet = new HashSet<>();
        for (Character c : J.toCharArray()){
            jSet.add(c);
        }

        int count = 0;
        for (Character c : S.toCharArray()){
            if(jSet.contains(c)){
                count++;
            }
        }
        return count;
    }

    /**
     * 344_ReverseString
     * Write a function that takes a string as input and returns the string reversed.
     * Example:
     * Given s = "hello", return "olleh".
     * exec 5ms
     */
    public String reverseString1(String s) {
        if(s==null || s.length()<=0){
            return s;
        }
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }

    //3ms
    public String reverseString2(String s) {
        if(s==null || s.length()<=0){
            return s;
        }
        int len = s.length()-1;
        char[] cs = s.toCharArray();
        for(int i=0,j=len ; i<j;i++,j--){
            char tc = cs[i];
            cs[i]=cs[j];
            cs[j]=tc;
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        StringType stringType = new StringType();
        do771(stringType);

    }

    private static void do771(StringType stringType) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println("771 石头与宝石:"+stringType.numJewelsInStones(J,S));
    }
}
