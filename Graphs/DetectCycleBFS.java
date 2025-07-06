import java.util.*;


class CycleBFS {
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
                if (bfs(i, adj, visited)) return true;
            }
        }
        return false;
    }

    private static boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, -1});
        visited[start] = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0], parent = curr[1];
            for (int neighbor : adj.get(node)) {
                if (visited[neighbor] == 0) {
                    visited[neighbor] = 1;
                    q.add(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}};
        System.out.println("Cycle Detected (BFS): " + isCycle(V, edges));
    }
}
