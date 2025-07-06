import java.util.*;

class CycleDFS {
    public static boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, -1, visited, adj)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(int node, int parent, int[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                if (dfs(neighbor, node, visited, adj)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}};
        System.out.println("Cycle Detected (DFS): " + isCycle(V, edges));
    }
}