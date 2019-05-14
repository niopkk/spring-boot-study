package com.数组中的重复数字;

import java.util.Arrays;

/**
 * com.数组中的重复数字
 * <p>
 * Created by tianxin2 on 2019-05-05
 */
public class RepeatMain {


    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 3};

        duplicate(nums, nums.length, nums);

        System.out.println(Arrays.toString(nums));


    }


    /**
     * todo 待优化
     *
     * @param nums
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[i] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
