package LeetCode.POTD;

import java.util.*;

public class minimum_replacements_to_sort_the_array {
//    public long minimumReplacement(int[] nums) {
//        ArrayList<Integer> arr = new ArrayList<>();
//        for(int i = nums.length -2; i>= 0 ; i--)
//        {
//            while(nums[i] > nums[i+1])
//            {
//                breakNums(nums , i ,arr );
//            }
//            if(nums[i] <= nums[i+1])
//            {arr.add(nums[i+1]);}
//        }
//
//        return (long)arr.length;
//    }

    private void breakNums(int[] nums , int i , ArrayList<Integer> arr)
    {
        int temp = nums[i];
        nums[i] = nums[i+1];
        while(nums[i] < nums[i-1])
        {
            nums[i] ++;
        }
        arr.add(nums[i]);
    }
}
