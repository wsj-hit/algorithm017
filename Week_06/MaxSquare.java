/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * 输入：
 * matrix = [["1","0","1","0","0"],
 *           ["1","0","1","1","1"],
 *           ["1","1","1","1","1"],
 *           ["1","0","0","1","0"]]
 *
 * 输出：4
 *
 */

public class MaxSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length < 1 || matrix[0].length <1){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ret = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    ret = Math.max(ret, dp[i][j]);
                }
            }
        }
        return ret*ret;
    }



    public int maximalSquare_1(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result*result;
    }
}
