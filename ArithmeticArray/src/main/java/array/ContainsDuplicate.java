package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
