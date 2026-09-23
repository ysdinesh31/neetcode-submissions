class Solution {
    public int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    ans ++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int m, int n) {
        grid[m][n] = '0';

        for(int[] dir : directions) {
            int i = m + dir[0];
            int j = n + dir[1];

            if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
                dfs(grid, i, j);
            }
        }
    }
}
