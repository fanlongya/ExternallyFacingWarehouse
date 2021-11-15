package array;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
         int max=Integer.MIN_VALUE;
         for(int i=0;i<nums.length;i++){
             int count=0;
             for(int j=0;j<nums.length;j++){
                 count += nums[j];
                 if(max < count){
                     max = count;
                 }
             }
         }
         return max;
    }
    public int maxSubArray1(int[] nums) {
        return max(nums, nums.length);
    }
    public int max(int[] nums, int n){
        if(nums.length==1){
            return nums[0];
        }
        int max=Integer.MIN_VALUE;
        if(nums[n-1]>0){
            max=max(nums, n-1)+nums[n-1];
        }else{
            max=max(nums,n-1);
        }
        return max;
    }

    public class Domain{
        public int lSum, rSum, mSum, iSum;

        public Domain(){}
        public Domain(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray2(int[] nums) {
        return mothed(nums, 0, nums.length-1).mSum;
    }

    public Domain mothed(int[] nums, int l, int r){
        if(l>r){
            return null;
        }
        if(l==r){
            return new Domain(nums[l], nums[l], nums[l], nums[l]);
        }
        int m=(l+r)/2;
        Domain lDomain = mothed(nums, l, m);
        Domain rDomain = mothed(nums, m+1, r);
        Domain domain = new Domain();
        domain.lSum = Math.max(lDomain.lSum, lDomain.iSum+rDomain.lSum);
        domain.rSum = Math.max(rDomain.rSum, rDomain.iSum+lDomain.rSum);
        domain.mSum = Math.max(Math.max(lDomain.mSum, rDomain.mSum), lDomain.rSum+rDomain.lSum);
        domain.iSum = lDomain.iSum + rDomain.iSum;
        return domain;
    }

    public static void main(String[] args){
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSubArray().maxSubArray2(nums));
    }

}
