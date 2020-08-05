package org.datagic.A_easy.array;

/**
 * Desc: 实现 strStr()
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/5 4:18 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0028_StrStr {
    /**
     * 题目：实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     * 如果不存在，则返回  -1。
     * ---------------------------------------------------------------------------------------------------------
     * 示例 1:
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * ---------------------------------------------------------------------------------------------------------
     * 题目解析：对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     * ---------------------------------------------------------------------------------------------------------
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * ---------------------------------------------------------------------------------------------------------
     * 题目解法：暴力法、优化暴力法、KMP算法
     */
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            // 比较两个字符串
            int temp = i;
            for (int j = 0; j < needle.length(); ++j) {
                if (haystack.charAt(temp) != needle.charAt(j)) {
                    break;
                }
                temp++;
                if (j == needle.length() - 1) {
                    return i;
                }
                if (temp == haystack.length()) {
                    return -1;
                }
            }
        }
        return -1;
    }
}
