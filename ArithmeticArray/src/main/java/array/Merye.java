package array;

import java.util.Arrays;

/**
 * . 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 */
public class Merye {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result=new int[m+n];
        for(int i=0;i<nums1.length;i++){
            result[i]=nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            if(m==0){
                result[i]=nums2[i];
            }else {
                result[m + i - 1] =nums2[i];
            }
        }
        Arrays.sort(result);
        nums1=result;
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {

    }

}
