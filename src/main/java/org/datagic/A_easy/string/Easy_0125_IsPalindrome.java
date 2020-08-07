package org.datagic.A_easy.string;

/**
 * Desc: 验证回文串
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/5 12:10 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0125_IsPalindrome {
    /**
     * 题目：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * ---------------------------------------------------------------------------------------------------------
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     * 输入: "race a car"
     * 输出: false
     * ---------------------------------------------------------------------------------------------------------
     * 题目解析：使用双指针从左至右、从右至左依次比较。
     * ---------------------------------------------------------------------------------------------------------
     * 时间复杂度： O(n) 空间复杂度：O(1)
     * ---------------------------------------------------------------------------------------------------------
     * 题目解法：使用双指针从左至右、从右至左依次比较。
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return true;
        }
        s = s.toLowerCase();
        int p = 0;
        int q = 0;
        while (p + q <= length) {
            if (p + q == length) {
                return true;
            }
            if (!Character.isLetterOrDigit(s.charAt(p))) {
                p++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(length - q - 1))) {
                q++;
                continue;
            }
            if (s.charAt(p) != s.charAt(length - q - 1)) {
                return false;
            }
            p++;
            q++;
        }
        return true;
    }

}
