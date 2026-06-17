class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:

        queue = collections.deque()

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0:
                    queue.append((i, j))
        
        directions = [(1,0),(0,1),(-1,0),(0,-1)]

        level = 0

        while queue:
            size = len(queue)
            level += 1
            for i in range(size):
                land = queue.popleft()
                for direction in directions:
                    m = land[0] + direction[0]
                    n = land[1] + direction[1]
                    if 0 <= m < len(grid) and 0 <= n < len(grid[0]) and grid[m][n] == 2147483647:
                        grid[m][n] = level
                        queue.append((m, n))
        
