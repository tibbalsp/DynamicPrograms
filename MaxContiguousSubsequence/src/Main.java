
/**
 * Author: Patrick Tibbals
 */

public class Main {

    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();
        System.out.println("\n"+msa.maxSubArray(new int[]{1,-2,4,-1,3}));
    }
}
/**
 * Searches input array for a subarray of values that generate
 * the largest sum.
 */
class MaxSubArray {
    /**
     *
     * @param nums
     * @return maximum sum of subarray
     */
    int maxSubArray(int[] nums) {

        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int ending = 0;
        int starting = 0;

        dp[0] = nums[0];
        int max = dp[0];
        for(int i =1;i < nums.length;i++) {
            if(Math.max(dp[i-1],0) == 0){
                dp[i] = nums[i];
                starting=i;
            }else {
                dp[i] = nums[i] + dp[i-1];
            }
            if(dp[i]>max){
                max = dp[i];
                ending = i;
            }
        }

        for( int j = starting; j <= ending;j++){
            System.out.print(nums[j]);
        }
        return max;
    }
}