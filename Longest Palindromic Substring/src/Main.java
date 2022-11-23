/**
 * Author: Patrick Tibbals
 */
public class Main {

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        LongestPalindromeNonDP lpndp = new LongestPalindromeNonDP();
        System.out.println(lps.LongestPalindromicSubstring("1456623"));
        System.out.println(lpndp.LongestPalindromeNonDP("1456623"));
    }

}
class LongestPalindromeNonDP {
    /**
     * Non-Dynamic programing solution
     * @param s
     * @return
     */
    public String LongestPalindromeNonDP(String s) {

        int finalLeft = 0;
        int finalRight = 0;

        int l = 0;
        int r = 0;

        for (int i = 0; i < s.length(); i++) {
            l = i;
            r = i;

            //Look left for duplicates
            while (l >= 0 && s.charAt(l) == s.charAt(i)) {
                l--;
            }

            //Look right for duplicates
            while (r < s.length() && s.charAt(r) == s.charAt(i)) {
                r++;
            }
            //Expand both sides and look for matches
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                l--;
                r++;
            }
            l = l + 1;

            // Replace with new longest when found
            if (finalRight - finalLeft < r - l) {
                finalLeft = l;
                finalRight = r;
            }
        }
        return s.substring(finalLeft, finalRight);
    }
}

class LongestPalindromicSubstring {

    /**
     * Find the longest palindromic substring in a given string input
     * @param s
     * @return Substring
     */
     String LongestPalindromicSubstring(String s) {
         //Map for duplicates 2=duplicate or 1=mismatched
         int[][] map = new int[s.length()][s.length()];
         //Map diagonal matching elements
         for (int i = 0; i < s.length(); i++) {
             map[i][i] = 2;
         }
         //Depth of matrix
         int l = 1;
         //Start and end of the longest substring
         int start = 0;
         int end = 0;
         while (l < s.length()) {
             for (int i = 0; i < s.length(); i++) {
                 if (i + l < s.length()) {
                     //Match so place 2 and look backwards left and down diagonally to detect if the inner matches as well
                     if (s.charAt(i) == s.charAt(i + l) && ( l<2 || map[i+1][i+l-1]==2)) {
                         map[i][i + l] = 2;
                         if(l > end - start){
                             start = i;
                             end = i+l;
                         }
                     // No match so place a 1
                     } else {
                         map[i][i + l] = 1;
                     }
                 }
             }
             l++;
         }
         return s.substring(start, end + 1);
    }



}

