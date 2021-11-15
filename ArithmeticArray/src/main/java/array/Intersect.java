package array;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map1 = getMap(nums1);
        Map<Integer, Integer> map2 = getMap(nums2);
        Set<Integer> keySet = map2.keySet();
        for(Integer key : keySet){
            if(map1.containsKey(key)){
                for(int i=0;i<Math.max(map1.get(key), map2.get(key));i++) {
                    list.add(key);
                }
            }
        }
        int[] nums =new int[list.size()];
        for(int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }
        return nums;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = getMap(nums1);
        int[] result=new int[nums2.length];
        int index=0;
        for(int temp:nums2){
            if(map.containsKey(temp)&&map.get(temp)!=0){
                result[index++]=temp;
                map.put(temp, map.get(temp)-1);
            }
        }
        return Arrays.copyOf(result, index);
    }

    public Map<Integer, Integer> getMap(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        return map;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] nums=new int[nums1.length];
        int index=0;
        int a=0;
        int b=0;
        while(a!=nums1.length || b!=nums2.length){
            int temp=nums1[a++];
            while (true) {
                if (temp == nums2[b]) {
                    nums[index++] = temp;
                    b++;
                    break;
                } else if (temp > nums2[b]) {
                    b++;
                } else if (temp < nums2[b]) {
                    break;
                }
            }
        }

        return Arrays.copyOf(nums, index);
    }

}
