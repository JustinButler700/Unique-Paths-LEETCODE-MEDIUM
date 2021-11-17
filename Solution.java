/*
Runtime: 0 ms
Memory Usage: 36 MB
Beats 100% of Java Submissions
*/
// Justin Butler 11/16/2021
class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1){return 1;}
        int[][] dp = new int[m+1][n+1];
        //DP pattern : Each node is the sum of its past paths. with past paths being either left or up.
        for(int i = 0; i <= m; i++)
        {
            for(int j = 0; j<=n; j++)
            {
                if(i==0) // top row is all 1, as there is only 1 way to traverse top
                {
                    dp[i][j] = 1;
                }
                else
                {
                    if(i-1 >=0 && j-1 >=0) // middle section is the sum of past paths
                    {
                        dp[i][j] = dp[i-1][j]+dp[i][j-1];
                    }
                    else if(j==0) //edge col = the above row.
                    {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}
