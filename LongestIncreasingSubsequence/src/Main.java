
import java.util.ArrayList;

/**
 * Author: Patrick Tibbals
 */
public class Main {
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println("\n"+lis.longestIncreasingSubsequence(new int[]{7,7,7,7,7,7}));
    }
}

/**
 * Class will find the long increasing non-contiguous subsequence
 */
class LongestIncreasingSubsequence{
    /**
     * Ill take in an unordered array of negatives or positive integer
     * and return the highest found sequence count. I have provided a
     * print-out to the console of the actually values of the sequence.
     * @param nums number list to search
     * @return max sequence length
     */
    int longestIncreasingSubsequence (int[] nums){
        //Sequence Counts
        int[] dp = new int[nums.length];
        //Sequence Map
        int[] sq = new int[nums.length];
        //Initialize dp to 1's and sq to -1's
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            sq[i] = -1;
        }
        //Max sequence counter
        int max = 1;
        //Position of max in dp
        int pos = -1;

        //For each element compare to the previous starting from 0 to i
        //when you find a smaller element at j then i then compare the dp counts
        //if it is a match or larger update the sq list with the index of the match
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && dp[j]+1 >= dp[i]){
                    dp[i] = dp[j]+1;
                    sq[i] = j;

                    if(max< dp[j]+1){
                        max = dp[j]+1;
                        pos = i;
                    }

                }
            }
        }

        //System.out.println(Arrays.toString(nums));
        //System.out.println(Arrays.toString(dp));
        //System.out.println(Arrays.toString(sq));

        //Gather the final list of our identified subsequence
        ArrayList<Integer> result = new ArrayList<>(nums.length);
        while(pos!=-1){
            result.add(0,nums[pos]);
            pos = sq[pos];
        }

        System.out.println(result.toString());


        return max ;

    }
}
