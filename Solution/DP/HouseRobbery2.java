package LeetCode.Solution.DP;
import java.util.*;

public class HouseRobbery2 {

    // Memoization
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        if(n == 2) return Math.max(nums[0] , nums[1]);

        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        int take_0th_index = recursion(nums , 0 , n-2 , dp);

        dp = new int[n+1];
        Arrays.fill(dp , -1);

        int take_1st_index = recursion(nums , 1 , n-1 , dp);

        return  Math.max(take_0th_index,take_1st_index);
    }

    private int recursion(int[] nums , int i , int n ,int[] dp)
    {

        if(i > n) return 0;

        if(dp[i] != -1)
        {
            return dp[i];
        }

        int steal = nums[i] + recursion(nums , i+2 , n , dp);

        int skip = recursion(nums , i+1 , n ,dp);

        return dp[i] = Math.max(steal , skip);
    }


    // Tabulation

    public int rob_Tabulation(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];


        int[] dp = new int[n+1];

        for(int i =1 ; i<= n-1 ; i++)
        {
            dp[i] = Math.max(nums[i-1] + (i-2 >= 0 ? dp[i-2] : 0) , dp[i-1]);
        }

        int take_0th_index = dp[n-1];

        dp = new int[n+1];

        for(int i =2 ; i<= n ; i++)
        {
            dp[i] = Math.max((i-2 >= 0 ?dp[i-2] : 0) + nums[i-1] , dp[i-1]);
        }

        int take_1st_index = dp[n];
        return Math.max(take_0th_index , take_1st_index );
    }
}
