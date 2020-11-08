/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 每次只能向下或者向右移动一步。
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 */

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        //grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == j && i == 0) {
                    continue;
                    //初始化第一行和列
                } else if (i == 0) {
                    //row
                    grid[i][j] = grid[0][j-1] + grid[0][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i-1][0] + grid[i][0];
                } else {
                    grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return  grid[grid.length-1][grid[0].length-1];
    }

/*    public int minPathSum(int[][] grid) {
        int ret = 0;

        //grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == j && i == 0) {
                    continue;
                //初始化第一行和列
                } else if (i == 0) {
                    //row
                    grid[i][j] = grid[0][j-1] + grid[0][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i-1][0] + grid[i][0];
                } else {
                    ret = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
                }
            }
        }

        return ret;
    }*/


}
