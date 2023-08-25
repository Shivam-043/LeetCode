package LeetCode.POTD;

import java.util.*;

public class text_justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int i =0;
        while(i < words.length)
        {
            int j =i+1;
            int letterCount = words[i].length();
            int spaceCount = 0;

            while(j< words.length && letterCount + words[j].length()+1 + spaceCount <= maxWidth)
            {
                spaceCount++;
                letterCount += words[j].length();
                j++;
            }

            int remainSpace = maxWidth - letterCount;

            int provideSpace = spaceCount ==0 ? 0 :  remainSpace / spaceCount;
            int extraSpace = spaceCount ==0 ? 0 : remainSpace % spaceCount;

            if(j == words.length)
            {
                provideSpace = 1;
                extraSpace = 0;
            }

            list.add(findLine(provideSpace , extraSpace , words , maxWidth , i , j));
            i = j;
        }

        return list;
    }

    private static String findLine(int provideSpace , int extraSpace , String[] words , int maxWidth , int i , int j)
    {
        StringBuilder ans = new StringBuilder();
        for(int k = i ; k< j ; k++)
        {
            ans.append(words[k]);
            if(k == j-1) continue;

            for(int z = 0; z< provideSpace; z++)
            {
                ans.append(" ");
            }
            if(extraSpace != 0)
            {
                ans.append(" ");
                extraSpace --;
            }

        }

        while(ans.length() != maxWidth)
        {
            ans.append(" ");
        }

        return ans.toString();
    }
}
