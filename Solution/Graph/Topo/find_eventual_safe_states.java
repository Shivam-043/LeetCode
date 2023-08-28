package LeetCode.Solution.Graph.Topo;
import java.util.*;
public class find_eventual_safe_states {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[graph.length];

        for(int i = 0 ; i< graph.length ; i++)
        {
            list.add(new ArrayList<Integer>());
        }

        for(int i = 0; i< graph.length ; i++)
        {
            for(int it : graph[i])
            {
                list.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i< graph.length ; i++)
        {
            if(indegree[i] == 0 )
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int node = q.peek();
            q.remove();

            ans.add(node);

            for(int i = 0 ;i< list.get(node).size(); i++)
            {
                indegree[list.get(node).get(i)] --;

                if(indegree[list.get(node).get(i)] == 0) q.add(list.get(node).get(i));
            }
        }

        Collections.sort(ans);

        return ans;

    }

}
