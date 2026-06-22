class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }
        return maxArea;
    
    }

    public int dfs(int m, int n, int[][] grid) {
        if ( m < 0 || m >= grid.length || n < 0 || n >= grid[0].length || grid[m][n] == 0) {
            return 0;
        }
        grid[m][n] = 0;
        return 1 + dfs(m + 1, n, grid) + dfs(m - 1, n, grid) + dfs(m, n + 1, grid) + dfs(m, n - 1, grid);
    }
}
