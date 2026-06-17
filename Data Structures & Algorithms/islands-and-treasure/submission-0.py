class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        queue = collections.deque([])

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0:
                    queue.append((i,j,0))

        directions = [(1,0),(0,1),(-1,0),(0,-1)]

        def is_valid(m,n):
            return 0 <= m < len(grid) and 0 <= n < len(grid[0])

        while queue:
            level = len(queue)
            for i in range(level):
                cell = queue.popleft()
                for direction in directions:
                    m = cell[0] + direction[0]
                    n = cell[1] + direction[1]
                    if is_valid(m,n) and grid[m][n] == 2147483647:
                        grid[m][n] = 1 + cell[2]
                        queue.append((m,n,grid[m][n]))
            

