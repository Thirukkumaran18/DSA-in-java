import java.util.*;

class Main{
    public static void main(String[] args){
        int V = 4 ; int E = 3 ; int edges[][] = {{3, 0}, {1, 0}, {2, 0}};
        System.out.println(topoSort(V, edges));
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
                
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edj[] : edges){
            adj.get(edj[0]).add(edj[1]);
        }
        
        Stack<Integer> st = new Stack<>();
        
        int visit[] = new int[V];
        
        for(int i=0;i<V;i++){
            if(visit[i] == 0){
                dfs(i, adj, visit, st);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while (!st.isEmpty()) {
            res.add(st.pop());
        }

        return res;
    }
    public static void dfs(int x, ArrayList<ArrayList<Integer>> adj, int[] visit, Stack<Integer> st){
        
        if(visit[x] == 1)return;
        
        visit[x] = 1 ;
        
        for(int neighbor : adj.get(x)){
            if(visit[neighbor] == 0){
                dfs(neighbor, adj, visit, st);
            }
        }
        st.push(x);
    }
}