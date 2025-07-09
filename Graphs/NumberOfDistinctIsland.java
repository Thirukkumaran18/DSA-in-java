import java.util.*;

class Main{
    public static void main(String[] args){

        int grid[][] = {
            {1, 1, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0}
        };

        int res = countDistinctIslands(grid);
    }
    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    List<String> shape = new ArrayList<>();
                    dfs(i, j, i, j, visited, grid, shape);
                    set.add(String.join(",", shape));
                }
            }
        }

        return set.size();
    }

    public static void dfs(int i, int j, int baseX, int baseY, boolean[][] visited, int[][] grid, List<String> shape) {
        int n = grid.length, m = grid[0].length;
        if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || grid[i][j] == 0)
            return;

        visited[i][j] = true;
        shape.add((i - baseX) + ":" + (j - baseY)); 

        dfs(i + 1, j, baseX, baseY, visited, grid, shape);
        dfs(i - 1, j, baseX, baseY, visited, grid, shape);
        dfs(i, j + 1, baseX, baseY, visited, grid, shape);
        dfs(i, j - 1, baseX, baseY, visited, grid, shape);
    }
}