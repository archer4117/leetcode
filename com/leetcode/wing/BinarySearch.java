package com.leetcode.wing;

/**
 * @author qxs on 2018/7/9.
 * 二分查找
 */
public class BinarySearch {

    /**
     * 35.搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * 示例 1:
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     * 输入: [1,3,5,6], 0
     * 输出: 0
     */
    public int searchInsert(int[] nums, int target) {

        int size = nums.length;
        int low = 0;
        int high = size;
        while (low<=high){
            int mid = (low+high)/2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target< nums[mid]){
                if(mid == 0){
                    return target< nums[mid]? 0:1;
                }
                if(target> nums[mid -1]){
                    return mid;
                }
                high = mid;
            }else if(target> nums[mid]){
                if(mid == size-1){
                    return target> nums[mid]? size:size-1;
                }
                if(target< nums[mid +1]){
                    return mid+1;
                }
                low = mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        do35(binarySearch);

    }

    private static void do35(BinarySearch binarySearch) {
        int[] nums = {1,3,5};
        int target = 4;
        System.out.println("35 搜索插入位置:"+binarySearch.searchInsert(nums,target));
    }
}
