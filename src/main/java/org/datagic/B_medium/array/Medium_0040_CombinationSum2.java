package org.datagic.B_medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Desc: 组合总和 II
 * Author: datagic (云瞻)
 * CreateDate: 2020/9/10 08:51 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Medium_0040_CombinationSum2 {

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(nums, target);
        for (List l : lists) {
            System.out.println(l);
        }
    }

    public static List<int[]> freq = new ArrayList<>();
    public static List<List<Integer>> ans = new ArrayList<>();
    public static List<Integer> sequence = new ArrayList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return ans;
    }

    public static void dfs(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<Integer>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest);

        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }

}
