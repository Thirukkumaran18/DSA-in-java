
import java.util.Arrays;

class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) return image;
        dfs(image, sr, sc, newColor, originalColor);
        return image;
    }

    private static void dfs(int[][] image, int x, int y, int newColor, int originalColor) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != originalColor) return;
        image[x][y] = newColor;
        dfs(image, x + 1, y, newColor, originalColor);
        dfs(image, x - 1, y, newColor, originalColor);
        dfs(image, x, y + 1, newColor, originalColor);
        dfs(image, x, y - 1, newColor, originalColor);
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int[][] result = floodFill(image, 1, 1, 2);
        for (int[] row : result) System.out.println(Arrays.toString(row));
    }
}