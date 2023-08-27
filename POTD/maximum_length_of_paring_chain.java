package LeetCode.POTD;

import java.util.*;

public class maximum_length_of_paring_chain {
    public int findLongestChain(int[][] pairs) {

        sortbyColumn(pairs , 1);

        int count =0;
        int min = Integer.MIN_VALUE;

        // for(int[] temp : pairs)
        // {
        //     System.out.println(temp[0] + " " + temp[1]);
        // }



        for(int i = 0 ; i< pairs.length ; i++)
        {
            if(min < pairs[i][0])
            {
                count ++;
                min = pairs[i][1];
            }

        }
        return count;
    }

    private static void sortbyColumn(int arr[][], int col)
    {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(final int[] entry1,
                               final int[] entry2)
            {
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });
    }
}
