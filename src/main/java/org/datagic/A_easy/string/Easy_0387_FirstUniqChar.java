package org.datagic.A_easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc: 字符串中的第一个唯一字符
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/4 11:54 上午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0387_FirstUniqChar {
    /**
     * 题目：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * ---------------------------------------------------------------------------------------------------------
     * 示例：
     * s = "leetcode"
     * 返回 0
     * s = "loveleetcode"
     * 返回 2
     * 提示：你可以假定该字符串只包含小写字母。
     * ---------------------------------------------------------------------------------------------------------
     * 题目解析：放在哈希表中计数，两次for循环遍历。
     * ---------------------------------------------------------------------------------------------------------
     * 时间复杂度：O(n) 空间复杂度：O(n)
     * ---------------------------------------------------------------------------------------------------------
     * 题目解法：遍历字符串s，放入哈希表计数，找到第一个计数为1的元素。
     */
    public static void main(String[] args) {
        String s = "loveleetcode";
        int res = firstUniqChar(s);
        System.out.println(res);
    }

    public static int firstUniqChar(String s) {
        int length = s.length();
        if (length == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
