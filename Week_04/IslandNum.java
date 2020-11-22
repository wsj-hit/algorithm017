import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class IslandNum {

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     */

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    mark(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void mark(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        mark(grid, i - 1, j);
        mark(grid, i, j - 1);
        mark(grid, i + 1, j);
        mark(grid, i, j + 1);

    }

    public int numIslands_bfs(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfsFill(grid,i,j);
                    count++;
                }
            }
        return count;
    }

    private void bfsFill(char[][] grid, int i, int j) {
        grid[i][j]='0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(i*m+j);
        while(!queue.isEmpty()){
            int code = queue.poll();
            int x = code/m;
            int y = code%m;

            if (x > 0 && grid[x-1][y] == '1') {
                queue.offer((x - 1)*m+y);
                grid[x-1][y] = '0';
            }

            if (y > 0 && grid[x][y-1] == '1') {
                queue.offer((x)*m+y-1);
                grid[x][y-1] = '0';
            }

            if (y < grid[x].length && grid[x][y+1] == '1') {
                queue.offer(x*m+y+1);
                grid[x][y+1] = '0';
            }

            if (x < grid.length && grid[x+1][y] == '1') {
                queue.offer((x + 1)*m+y);
                grid[x+1][y] = '0';
            }

        }



    }
}
