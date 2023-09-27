package LeetCode.POTD;

import java.util.*;
public class path_with_minimum_effort {
    public int minimumEffortPath(int[][] heights) {
        int[][] visited = new int[heights.length][heights[0].length];
        for(int[] temp : visited)
        {
            Arrays.fill(temp , Integer.MAX_VALUE);
        }
        visited[0][0] = 0;
        dikstra(0 , 0 , heights , visited);

        return visited[heights.length-1][heights[0].length-1];
    }

    private static void dikstra(int i , int j , int[][] height , int[][] visited)
    {
        PriorityQueue<tuple> pqueue = new PriorityQueue<>(new Comparator<tuple>(){
            @Override
            public int compare(tuple a , tuple b)
            {
                return b.getKey() - a.getKey();
            }
        });
        int[] init = {i , j};
        pqueue.add(new tuple(0 , init));

        while(!pqueue.isEmpty())
        {
            int diff = pqueue.peek().getKey();
            int[] arr = pqueue.peek().getValue();
            pqueue.remove();

            // if(arr[0] == height.length-1 && arr[1] == height[0].length-1)
            // {
            //   return;
            // }

            int[] r = {-1 , 0 , 0 , 1};
            int[] c = {0 , -1 , 1 , 0};

            for(int p = 0 ; p < 4 ; p++)
            {
                int x = arr[0] + r[p];
                int y = arr[1] + c[p];

                if(x>=0 && x < height.length && y < height[0].length && y >= 0)
                {
                    int newDiff = Math.max(Math.abs(height[arr[0]][arr[1]] - height[x][y]), diff);
                    if(visited[x][y] > newDiff)
                    {
                        visited[x][y] = newDiff;
                        int[] temp = {x , y};
                        pqueue.add(new tuple(newDiff , temp));
                    }
                }
            }
        }
    }
}

class tuple{
    int a;
    int[] b;
    tuple(int a , int[] b)
    {
        this.a = a;
        this.b = b;
    }

    int getKey()
    {
        return a;
    }

    int[] getValue()
    {
        return b;
    }
}
