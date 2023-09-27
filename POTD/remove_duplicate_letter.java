package LeetCode.POTD;

import java.util.*;

public class remove_duplicate_letter {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        boolean[] taken = new boolean[26];

        StringBuilder str = new StringBuilder();

        for(int i = 0 ; i< s.length() ; i++)
        {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int p = 0;
        str.append(s.charAt(0));
        taken[s.charAt(0) - 'a'] = true;

        for(int i = 1 ;i < s.length() ; i++)
        {
            while(p >=0 && !taken[s.charAt(i) -'a'] && s.charAt(i) < str.charAt(p))
            {
                if(lastIndex[str.charAt(p) -'a'] > i)
                {
                    System.out.println(str.toString());
                    taken[str.charAt(p) - 'a'] = false;
                    str.deleteCharAt(p);
                    p--;
                    // if(p <0) p++;
                }else{
                    str.append(s.charAt(i));
                    taken[s.charAt(i) - 'a'] = true;
                    p++;
                }
            }
            // if(p <0) p++;
            if((str.length() == 0)||(!taken[s.charAt(i) -'a'] && s.charAt(i) >= str.charAt(p))){
                taken[s.charAt(i) - 'a'] = true;
                str.append(s.charAt(i));
                p++;
            }
        }

        return str.toString();
    }
}
