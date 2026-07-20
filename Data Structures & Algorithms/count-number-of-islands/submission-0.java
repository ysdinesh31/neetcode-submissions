class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int i , int j) {
        grid[i][j] = '0';
        int m = grid.length;
        int n = grid[0].length;
        if(i + 1 < m && grid[i + 1][j] == '1'){
            dfs(grid, i+1, j);
        }
        if(i - 1 >= 0 && grid[i - 1][j] == '1'){
            dfs(grid, i - 1, j);
        }
        if(j + 1 < n && grid[i][j + 1] == '1'){
            dfs(grid, i, j + 1);
        }
        if(j - 1 >= 0 && grid[i][j - 1] == '1'){
            dfs(grid, i, j - 1);
        }
    }
}
