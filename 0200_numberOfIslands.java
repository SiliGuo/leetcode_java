// DFS
class Solution {    
    public int numIslands(char[][] grid) {
        // Empty condition
        if (grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;
        
        // Number of islands
        int numOfIslands = 0;
        
        // Loop through each unvisited node and iterates through its neighboors
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    ++numOfIslands;
                    dfs(grid, i, j);
                }
            }
        }
        return numOfIslands;
    }
    
    public void dfs(char[][] grid, int i , int j) {
        // If out of boundary, return
        if (i < 0 || i >= grid.length || j <  0 || j >= grid[0].length) return;
        // If not connected or visited already return
        if (grid[i][j] != '1') return;
        
        // Mark visited node as '2'
        grid[i][j] = '2';
        
        // iterates through 4 moving directions
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
