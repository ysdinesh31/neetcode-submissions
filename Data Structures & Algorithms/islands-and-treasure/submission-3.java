class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        int max = 2147483647;
        for (int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int dist = 0;
        int m = grid.length;
        int n = grid[0].length;
        while(!queue.isEmpty()) {
            dist ++;
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int[] cell = queue.removeFirst();
                int i = cell[0]; int j = cell[1];
                if (i + 1 < m && grid[i+1][j] == max) {
                    grid[i + 1][j] = dist;
                    queue.add(new int[]{i + 1, j});
                }
                if (j + 1 < n && grid[i][j+1] == max) {
                    grid[i ][j + 1] = dist;
                    queue.add(new int[]{i, j + 1});
                }
                if (i - 1 >= 0 && grid[i-1][j] == max) {
                    grid[i - 1][j] = dist;
                    queue.add(new int[]{i - 1, j});
                }
                if (j - 1 >= 0 && grid[i][j - 1] == max) {
                    grid[i][j - 1] = dist;
                    queue.add(new int[]{i, j - 1});
                }
            }
        }
    }
}
