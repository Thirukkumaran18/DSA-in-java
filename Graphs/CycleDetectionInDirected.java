import java.util.*;

class Main{
    public static void main(String[] args){
        int V = 4 ; int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        boolean res = isCyclic(V, edges);
        System.out.println("Is cyclic : "+res);
    }
    public static boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        int[] visited = new int[V];
        int pathVisit[] = new int[V];
        
        for(int i=0;i<V;i++){
            if(visited[i] == 0){
                if(dfs(i, visited, pathVisit, adj))return true;
            }
        }

        

        return false;
    }

    public static boolean dfs(int node, int[] visit, int pathVisit[], List<List<Integer>> adj) {
        
        if(visit[node] == 1 && pathVisit[node] == 1)return true ;
        
        if(visit[node] == 1 && pathVisit[node] == 0)return false;

        visit[node] =1 ;
        pathVisit[node] = 1;
        
        for (int neighbor : adj.get(node)) {
            if(dfs(neighbor, visit, pathVisit, adj))return true;
        }
        pathVisit[node] = 0 ;

        return false;
    }
}