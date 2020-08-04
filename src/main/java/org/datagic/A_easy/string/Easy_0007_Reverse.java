package org.datagic.A_easy.string;

/**
 * Desc: 整数反转
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/3 4:58 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0007_Reverse {
    /**
     * 题目：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * ---------------------------------------------------------------------------------------------------------
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * 输入: 120
     * 输出: 21
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * ---------------------------------------------------------------------------------------------------------
     * 题目解析：把int型的值，类似堆栈一样pop和push。
     * ---------------------------------------------------------------------------------------------------------
     * 时间复杂度：O(log(x))，x中大约有 ln(x) 位数字。
     * ---------------------------------------------------------------------------------------------------------
     * 题目解法：x % 10 弹出 低位的值，res = res*10 + pop 组装成高位
     */
    public static void main(String[] args) {
        int x = -321;
        int res = reverse(x);
        System.out.println(res);
    }

    public static int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        int res = 0;
        int pop = 0;
        while (x != 0) {
            pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }
}
