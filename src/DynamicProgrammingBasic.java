import java.util.Arrays;

public class DynamicProgrammingBasic {

    void solve() {
        int n = 18;
        int a[] = {7, 5, 1};

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int ans = minCoins(n, a, dp);
        System.out.println(ans);

        for (int x : dp) {
            System.out.print(x + " ");
        }
    }

    private int minCoins(int n, int a[], int dp[]) {

        if (n == 0) return 0;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (n - a[i] >= 0) {
                int subAns = 0;
                if (dp[n - a[i]] != -1) {
                    subAns = dp[n - a[i]];
                } else {
                    subAns = minCoins(n - a[i], a, dp);
                }
                if (subAns != Integer.MAX_VALUE &&
                        subAns + 1 < ans) {
                    ans = subAns + 1;
                }
            }
        }
        return dp[n] = ans;
    }


    /**
     * https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
     * Given two strings, find the length of longest subsequence present in both of them.
     * Both the strings are in uppercase latin alphabets.
     * Input:
     * A = 6, B = 6
     * str1 = ABCDGH
     * str2 = AEDFHR
     * Output: 3
     * Explanation: LCS for input strings “ABCDGH” and “AEDFHR” is “ADH” of length 3.
     * <p>
     * Input:
     * A = 3, B = 2
     * str1 = ABC
     * str2 = AC
     * Output: 2
     * Explanation: LCS of "ABC" and "AC" is "AC" of length 2.
     */

    void lcs() {
        int x = 6, y = 6;
        String s1 = "ABCDGH", s2 = "AEDFHR";
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = findLCS(x, y, s1, s2, dp);
        System.out.println("Longest Contineous Sequence: " + ans);
    }

    private int findLCS(int m, int n, String s1, String s2, int[][] dp) {
        if (m == 0 || n == 0)
            return 0;

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return dp[m][n] = 1 + findLCS(m - 1, n - 1, s1, s2, dp);
        } else {
            return dp[m][n] = Math.max(findLCS(m - 1, n, s1, s2, dp), findLCS(m, n - 1, s1, s2, dp));
        }
    }
}
