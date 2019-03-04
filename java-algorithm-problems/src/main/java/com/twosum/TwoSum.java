package com.twosum;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TwoSum {

//    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
//    示例:
//
//    给定 nums = [2, 7, 11, 15], target = 9
//
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]


    public static void main(String[] args) {
        int[] nums = new int[]{11, 2, 15, 7};
        int taget = 13;
        System.out.println(Arrays.toString(getTwoSum(nums, taget)));
        System.out.println(Arrays.toString(getTwoSumMap(nums, taget)));
        System.out.println(Arrays.toString(getTwoSumOneMap(nums, taget)));


//        System.out.println(System.getSecurityManager());
    }

    //第一算法
    private static int[] getTwoSum(int[] ints, int target) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] == target - ints[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //两遍哈希表
    private static int[] getTwoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //一遍遍哈希表
    private static int[] getTwoSumOneMap(int[] nums, int target) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    //复写
//    private static int[] conpy(int[] ints, int tager) {
//        Map<Integer, Integer> result = new HashMap<>();
//        for (int i = 0; i < ints.length; i++) {
//            int complement = tager - ints[i];
//
//            if (result.containsKey(complement)) {
//                return new int[]{result.get(complement), i};
//            }
//            result.put(ints[i], i);
//        }
//        return null;
//    }
}
