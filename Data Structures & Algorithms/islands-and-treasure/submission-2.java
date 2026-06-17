class Solution {
    public void islandsAndTreasure(int[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int distance = 1;
        int[][] directions = new int[][]{{0, 1}, {1, 0},{-1, 0},{0, -1}};

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                int[] cell = queue.removeFirst();
                for(int[] direction: directions){
                    int m = cell[0] + direction[0];
                    int n = cell[1] + direction[1];
                    if(m >= 0 && n >= 0 && m < grid.length && n < grid[0].length && grid[m][n] > 0 && grid[m][n] == Integer.MAX_VALUE){
                        grid[m][n] = distance;
                        queue.add(new int[]{m, n});
                    }
                }
            }
            distance += 1;
        }
    }
}
