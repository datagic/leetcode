package org.datagic.A_easy.string;

/**
 * Desc: 最长公共前缀
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/6 6:30 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0014_LongestCommonPrefix {
    /**
     * 题目：编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * ---------------------------------------------------------------------------------------------------------
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * 所有输入只包含小写字母 a-z 。
     * ---------------------------------------------------------------------------------------------------------
     * 题目解析：可以从每一个串的前面开始遍历比较，最容易想到的方式；也可以使用二分法，以最小长度的串的中间值作为第一个二分点，
     * 如果二分点与之前的前缀都相同，则至少公共前缀大于等于到二分点的长度，否则一定小于到二分点的长度。
     * ---------------------------------------------------------------------------------------------------------
     * 时间复杂度： O(n) 空间复杂度：O(n)
     * ---------------------------------------------------------------------------------------------------------
     * 题目解法：使用横向遍历比较。
     */
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 多个值的操作转换为两个值的操作
            prefix = twoPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }

    // 获取两个字符串的公共前缀
    public static String twoPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < minLength && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
