package org.datagic.A_easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc: 有效的字母异位词
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/4 3:23 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0242_IsAnagram {
    /**
     * 题目：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * ---------------------------------------------------------------------------------------------------------
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     * ---------------------------------------------------------------------------------------------------------
     * 题目解析：
     * ---------------------------------------------------------------------------------------------------------
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * ---------------------------------------------------------------------------------------------------------
     * 题目解法：
     */
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!sMap.containsKey(t.charAt(i))) {
                return false;
            } else if (sMap.get(t.charAt(i)) == 1) {
                sMap.remove(t.charAt(i));
            } else {
                sMap.put(t.charAt(i), sMap.get(t.charAt(i)) - 1);
            }
        }
        return true;
    }
}
