import java.util.*;
class Main{
    public static void main(String[] args){
        int V = 4 ; int edges[][] = {{0, 3}, {1, 2}, {3, 2}, {0, 2}};
        boolean res = isBipartite(V, edges);

        System.out.println("Is graph bipartitde : "+res);
    }
    public static boolean isBipartite(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edj : edges){
            int u = edj[0];
            int v = edj[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int n = edges.length;
        int m = edges[0].length;
        int visit[] = new int[V];
        for(int i=0;i<V;i++){
            if(visit[i] == 0){
                if(!dfs(i, visit, adj, 1))return false;
            }
        }
        return true;
    }
    public static boolean dfs(int x, int[] visit, List<List<Integer>> list, int val){
        if(x>=list.size())return true ;
        
        if(visit[x] != 0){
            if(visit[x] == val)return true;
            return false;
        }
        
        visit[x] = val;
        
        for(int edge : list.get(x)){
            if(!dfs(edge, visit, list, val == 1 ? 2 : 1))return false;
        }
        return true; 
    }
}