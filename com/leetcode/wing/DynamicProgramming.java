package com.leetcode.wing;

import java.util.Arrays;
import java.util.List;

/**
 * @author qxs on 2018/7/11.
 * 动态规划
 */
public class DynamicProgramming {

    int[] cache = new int[1000];

    /**
     * 70.climbing-stairs
     * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     * 示例 1：
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 步 + 1 步
     * 2.  2 步
     * 示例 2：
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 步 + 1 步 + 1 步
     * 2.  1 步 + 2 步
     * 3.  2 步 + 1 步
     *
     * @param n 台阶数
     * @return 可选择的方式
     */
    private int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        cache[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return cache[n];
    }

    private int climbStairs1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2:
     * 输入: [2,7,9,3,1]
     * 输出: 12
     * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     */
    Integer[] max = new Integer[1000];

    private int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            max[0] = 0;
            return max[0];
        }
        if (len == 1) {
            max[1] = nums[0];
            return max[1];
        }
        if (len == 2) {
            max[2] = Math.max(nums[0], nums[1]);
            return max[2];
        }
        if (max[len] == null) {
            max[len] = nums[len - 1] + rob(Arrays.copyOf(nums, len - 2));
        }
        if (max[len - 1] == null) {
            max[len - 1] = nums[len - 2] + rob(Arrays.copyOf(nums, len - 3));
        }
        return Math.max(max[len], max[len - 1]);
    }

    private int maxSubArray(int[] nums) {
        int max = nums[0];
        int temp = 0;
        for (int num : nums) {
            if (temp > 0) {
                temp += num;
            } else {
                temp = num;
            }
            max = Math.max(temp, max);
        }
        return max;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // 可以类比于背包问题
        int n = s.length();
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }

    /**
     * 292_NimGame
     * You are playing the following Nim Game with your friend: There is a heap of stones on the table,
     * each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner.
     * You will take the first turn to remove the stones.
     * Both of you are very clever and have optimal strategies for the game.
     * Write a function to determine whether you can win the game given the number of stones in the heap.
     * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove,
     * the last stone will always be removed by your friend.
     */
    public boolean canWinNim(int n) {
        return !(n%4==0);
    }

 public static void main(String[] args) {
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
//        do70(dynamicProgramming);
//        do198(dynamicProgramming);
//        do53(dynamicProgramming);
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        dynamicProgramming.wordBreak(s,wordDict);
    }

    private static void do53(DynamicProgramming dynamicProgramming) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = dynamicProgramming.maxSubArray(nums);
        System.out.println("70.Maximum Subarray:" + max);
    }

    private static void do70(DynamicProgramming dynamicProgramming) {
        int n = 3;
        System.out.println("70.climbing-stairs:" + dynamicProgramming.climbStairs1(n));
    }

    private static void do198(DynamicProgramming dynamicProgramming) {
        int[] nums = {0};

        System.out.println("198.house-robber:" + dynamicProgramming.rob(nums));
    }
}
