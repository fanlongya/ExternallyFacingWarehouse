package array;


import java.util.*;

public class NumbersThatAppearOnlyOnce {
    public static void main(String[] args) {
        System.out.println(model1(new int[]{1,2,4,5,7,2,4,5,1}));
    }
    private static Integer model1(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=null){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        Set<Integer> keySet=map.keySet();
        Iterator iterator=keySet.iterator();
        while (iterator.hasNext()){
            Integer key=(Integer) iterator.next();
            if(map.get(key).equals(1)){
                return key;
            }
        }
        return -1;
    }
    private static Integer model2(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        Iterator<Integer> setIt=set.iterator();
        return setIt.next();
    }
    private static Integer model3(int[] nums) {
        int result=0;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                result-=nums[i];
            }else{
                set.add(nums[i]);
                result+=nums[i];
            }
        }
        return result;
    }
    private static Integer model4(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i+=2){
            if(nums[i]==nums[i+1]){
                continue;
            }else{
                return nums[i];
            }
        }
        if(nums[nums.length-2]!=nums[nums.length-1]){
            return nums[nums.length-1];
        }
        return -1;
    }
}
