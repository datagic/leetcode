package org.datagic.A_easy.string;

/**
 * Desc: 字符串相加
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/4 2:14 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0415_AddStrings {
    /**
     * 题目：给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * ---------------------------------------------------------------------------------------------------------
     * 提示：
     * num1 和num2 的长度都小于 5100
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
     * ---------------------------------------------------------------------------------------------------------
     * 题目解析：一个char的内容是数字，该char的ASCII码-48就是等于该字符串内容的真实的数值。
     * ---------------------------------------------------------------------------------------------------------
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * ---------------------------------------------------------------------------------------------------------
     * 题目解法：本题着重考虑ASCII码和进位即可。
     */
    public static void main(String[] args) {
        String num1 = "28378";
        String num2 = "81234";
        String result = addStrings(num1, num2);
        System.out.println(result);
    }

    public static String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        if ((length1 == 0 && length2 == 0) || length1 >= 5100 || length2 >= 5100) {
            return "0";
        }
        if (length1 < length2) {
            return addStrings(num2, num1);
        }
        StringBuffer stringBuffer = new StringBuffer(length1 + 1);
        int ascii = 48;
        int jump = 0;
        boolean flag;
        for (int i = length1 - 1; i >= 0; i--, --length2) {
            int a1 = +num1.charAt(i) - ascii;
            int a2 = 0;
            if (length2 > 0) {
                a2 = +num2.charAt(length2 - 1) - ascii;
            }
            int add = a1 + a2;
            if (add + jump >= 10) {
                flag = true;
                add = (add + jump) % 10;
            } else {
                flag = false;
                add = add + jump;
            }
            stringBuffer.append(add);
            if (flag) {
                jump = 1;
            } else {
                jump = 0;
            }
        }
        if (jump == 1) {
            stringBuffer.append(1);
        }
        String res = stringBuffer.toString();
        StringBuffer result = new StringBuffer();
        for (int i = res.length() - 1; i >= 0; i--) {
            char c = res.charAt(i);
            result.append(c);
        }
        return result.toString();
    }
}
