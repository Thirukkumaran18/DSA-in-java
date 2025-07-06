
import java.util.LinkedList;
import java.util.Queue;

class RottenOranges {
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                for (int[] d : dirs) {
                    int ni = cell[0] + d[0], nj = cell[1] + d[1];
                    if (ni >= 0 && nj >= 0 && ni < rows && nj < cols && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        q.add(new int[]{ni, nj});
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0 ? time - 1 : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println("Minutes to rot all oranges: " + orangesRotting(grid));
    }
}
