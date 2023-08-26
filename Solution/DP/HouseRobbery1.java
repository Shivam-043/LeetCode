package LeetCode.Solution.DP;

public class HouseRobbery1 {
    // Recursion + Tabulation
    public int rob(int[] nums) {

        if(nums.length == 0)
        {
            return 0;
        }
        else if(nums.length == 1)
        {
            return nums[0];
        }

        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);

        for(int i =2 ; i< nums.length ; i++ )
        {
            dp[i] = Math.max(dp[i-2] + nums[i] , dp[i-1]);
        }

        return dp[nums.length -1];
    }

    // Recursion + Memoization
    public int rob(int[] nums , int i , int[] dp)
    {
        if(i > nums.length) return 0;
        if(dp[i] != -1) return dp[i];

        int steal = nums[i] + rob(nums , i+2 , dp);
        int skip = 0 + rob(nums , i+1 , dp);

        return Math.max(steal , skip);
    }

}
