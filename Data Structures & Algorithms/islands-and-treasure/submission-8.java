class Solution {
    public void islandsAndTreasure(int[][] grid) {
        List<int[]> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new int[]{i,j});
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int dist = 0;
        int[][] dirs = new int[][]{{1, 0}, {0,1}, {-1, 0}, {0, -1}};

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cell = queue.removeFirst();
                if (grid[cell[0]][cell[1]] <= dist) continue;
                grid[cell[0]][cell[1]] = dist;
                for(int[] dir:dirs) {
                    int m = cell[0] + dir[0];
                    int n = cell[1] + dir[1];
                    if(m >= 0 && n >= 0 && m < grid.length && n < grid[0].length && grid[m][n] == Integer.MAX_VALUE) queue.addLast(new int[]{m, n});
                }
            }
            dist ++;
        }
    }
}
