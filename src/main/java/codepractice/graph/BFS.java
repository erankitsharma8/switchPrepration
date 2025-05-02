package codepractice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private static ArrayList<Integer> bfsGraph(int v, List<List<Integer>> adj){
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean[] visited=new boolean[v];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            Integer n=q.poll();
            bfs.add(n);
            for(Integer a:adj.get(n)){
                if(!visited[a]){
                 visited[a]=true;
                 q.add(a);
                }
            }
        }
      return bfs;
    }

    public static void main(String[] args) {
          List<List<Integer>> ask= List.of(List.of(2,6),List.of(1,3,4),List.of(2),List.of(2,5),List.of(4,8),List.of(1,7,9)
          ,List.of(6,8),List.of(5,7),List.of(6));
          List<Integer> answer=bfsGraph(9,ask);
          answer.forEach(System.out::println);
    }
}
