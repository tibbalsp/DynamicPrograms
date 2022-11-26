/**
 * Author:  Patrick Tibbals
 *
 * Change Making problem with assumptions:
 *  -- Coin list c[1]=1 so any combo can be gathered
 *  -- Coins are never negative
 *
 */
public class Main {

    public static void main(String[] args) {
        MakingChange makingChange = new MakingChange();
        System.out.println(makingChange.makingChange(new int[]{1,2,5,7},45));    }
}

/**
 * Class will determine the smallest combination of coins to reach desired change.
 */
class MakingChange {
    /**
     * Manage the coinList to deirtimn
     * @param coinList list of coin values
     * @param totalChange total value to make change for
     * @return minimum number of change needed to make your totalChange
     */
    int makingChange(int[] coinList, int totalChange) {
        // Map for coin count
        int[] dp = new int[totalChange + 1];
        //Iterate from 1 to totalChange
        for (int i = 1; i <= totalChange; i++) {
            int temp = Integer.MAX_VALUE;
            // Look backwards for the minimum amount of coins for each combination
            // looking back according to the current coins value on the chart.
            for (int k : coinList) {
                if (k <= i) {
                    temp = Math.min(dp[i - k], temp);
                }
            }
            //Add one for the current position we are located on.
            dp[i] = temp + 1;
        }
        return dp[dp.length-1];
    }
}
