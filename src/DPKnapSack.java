public class DPKnapSack {

    void solve() {
        int w = 10;
        int n = 4;
        int[] val = {20, 30, 10, 50};
        int[] wt = {1, 3, 4, 6};

        int dp[][] = new int[n + 1][w + 1];

        for (int i=0; i< n + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i=0; i< w + 1; i++) {
            dp[0][i] = 0;
        }

        int ans = performDP(n, w, val, wt, dp);
        System.out.println("Max Value: " + ans);
    }

    private int performDP(int n, int W, int[] val, int[] wt, int[][] dp) {

        for (int i = 1; i < n + 1; i++) {

            for (int j = 1; j < W + 1; j++) {

                if (wt[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[n][W];
    }
}
