package com.aaron.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leecode
 * @description: 无重复字符的最长子串
 * @author: tianpanke
 * @create: 2020-05-18
 **/
public class Algorithm3 {
    /**
     * desc:给定一个字符串，请你找出不含有重复字符串的最长子串的长度
     */

    public static void main(String[] args) {

    }


    /**
     * 以abcabcbb为例，找出从每一个字符开始的，不包含重复字符的最长子串，其中最长的那个字符串即为答案。
     * （a）bcabcbb -->(abc)abcbb  3
     * a(b)cabcbb -->a(bca)bcbb 3
     * ab(c)abcbb -->ab(ca)bcbb 2
     * abc(a)bcbb -->abc(abc)bb 3
     * abca(b)cbb -->abca(bc)bb 2
     * abcab(c)bb -->abcab(cb)b 2
     * abcabc(b)b -->abcabc(b)b 1
     * abcabcb(b) -->abcabcb(b) 1
     * 从中不难发现如果我们依次递增地枚举子串地起始位置，那么子串地结束位置也是递增地。这里地原因在于，假设我们
     * 选择字符串中的第k个字符作为起始位置，并且得到了不包含重复字符的最长子串的结束位置rk。那么当我们选择第
     * k+1个字符作为起始位置，首先从k+1到rK的字符显然是不重复的。
     * 这样我们可以使用滑动窗口来解决这个问题了。
     * 1）我们使用两个指针标识某个子串的左右边界。其中左指针代表起始位置，右指针代表结束位置。
     * 2）在每一步的操作中，我们回将左指针向右边移动，表示我们要开始枚举下O一个字符作为起始位置。然后我们可以不断向
     * 右边移动右指针，但需要保证两个指针对应的子串么有重复的字符。
     * 3）枚举结束后，找到最长的子串即为答案。
     * 4）判断重复字符，利用哈希集合。在左指针向右移动的时候，我们从哈希集合中移除一个字符，在右指针向右移动的时候，我们往哈希集合中添加一个字符。
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(∣Σ∣)，其中 |Σ| 表示字符集（即字符串中可以出现的字符）
     */
    public int lengthOfLongestSubString(String s) {
       //哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int len=s.length();
        //右指针
        int rk=-1;
        int ans=0;
        for(int i=0;i<len;i++){
            if(i!=0){
                //左指针右移动一格，移除一个字符
                occ.remove(s.charAt(i-1));
            }
            while(rk+1<len&&!occ.contains(s.charAt(rk+1))){
                //不断右移右指
                occ.add(s.charAt(rk+1));
                ++rk;
            }
            ans=Math.max(ans,rk-i+1);

        }

        return ans;
    }
}
