class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1'){
                    dfs(i, j, grid);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(int x, int y, char[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') 
            return;
        grid[x][y] = '0';

        for (int i = 0; i < 4; i++) {
            dfs(dx[i] + x, dy[i] + y, grid);
        }
    }
}