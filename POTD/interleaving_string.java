package LeetCode.POTD;

public class interleaving_string {
    int m , n , N;
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        N = s3.length();

        if(N != m + n) return false;

        dp = new Boolean[m +1][n +1];

        return recursive(0 , 0 , s1 ,s2 , s3);
    }
    private Boolean recursive(int i , int j , String s1 , String s2 , String s3)
    {
        if(i+j >= N && i >= m && j >= n) return true;

        if(i+j >= N) return false;

        if(dp[i][j] != null)
        {
            return dp[i][j];
        }

        boolean result= false;


        if(i< m && s1.charAt(i) == s3.charAt(i+j))
        {
            result = recursive(i+1 , j , s1 ,s2 , s3);
        }

        if(result) return dp[i][j] = result ;

        if(j < n && s2.charAt(j) == s3.charAt(i+j))
        {
            result = recursive(i , j+1, s1 ,s2 , s3);
        }


        return dp[i][j] = result;
    }
}
