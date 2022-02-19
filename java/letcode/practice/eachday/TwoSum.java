package letcode.practice.eachday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 * 2022-02-19
 *
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        Integer[] ints = {10,3,5,7,9};
        int target = 8;
        int[] ints1 = twoSum.twoSumHash(ints, target);
        System.out.println(Arrays.toString(ints1));
    }

    /**
     * 两层for循环暴力
     * @param nums
     * @param target
     * @return
     */
    public Integer[] twoSum(Integer[] nums,Integer target){
        for (int i = 0; i < nums.length; i++) {
            if (target<=nums[i]){
                continue;
            }
            int a = target-nums[i];
            for (int j = i; j < nums.length; j++) {
                if (a==nums[j]){
                    return new Integer[]{i,j};
                }
            }
        }
        System.out.println("no data match");
        return null;
    }

    /**
     * 1.new 一个map
     * 2.判断map中是否存在target减去nums【i】，若存在，直接返回nums【i】下标和map中对应的value
     * 3.若不存在则把nums【i】以及i put进入map
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHash(Integer[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
