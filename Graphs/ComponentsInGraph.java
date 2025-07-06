import java.util.*;

class GraphComponents {
    public static ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(i, visited, adj, comp);
                components.add(comp);
            }
        }

        return components;
    }

    private static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> comp) {
        visited[node] = true;
        comp.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, comp);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1}, {2, 1}, {3, 4}};
        ArrayList<ArrayList<Integer>> components = getComponents(V, edges);
        System.out.println("Connected Components: " + components);
        System.out.println("Number of Components: " + components.size());
    }
}