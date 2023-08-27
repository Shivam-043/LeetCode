package LeetCode.Concepts.Graph;

import java.util.*;

public class Dijkstra {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());

        queue.add(new Pair(0 , S));
        int [] ans = new int[V];
        Arrays.fill(ans , Integer.MAX_VALUE);
        ans[S] = 0;

        while(!queue.isEmpty())
        {
            int dist = queue.peek().getKey();
            int node = queue.peek().getValue();
            queue.remove();

            for(int i =0 ; i< adj.get(node).size() ; i++)
            {
                if(dist + adj.get(node).get(i).get(1) < ans[adj.get(node).get(i).get(0)])
                {
                    queue.add(new Pair(dist + adj.get(node).get(i).get(1) , adj.get(node).get(i).get(0)));
                    ans[adj.get(node).get(i).get(0)] = dist + adj.get(node).get(i).get(1);
                }
            }
        }

        return ans;
    }
}

class Pair{
    int key;
    int value;

    Pair(int key , int value)
    {
        this.key = key;
        this.value = value;
    }

    int getKey()
    {
        return key;
    }

    int getValue()
    {
        return value;
    }
}
