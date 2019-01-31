package algocasts.plan100.part1;

/**
 * No.7 行列递增的二维数组搜索
 *
 * @author Lin
 */
public class SearchInMatrix {

    private static int[] searchInMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length==0 || matrix[0] ==null || matrix[0].length == 0){
            return new int[]{-1,-1};
        }
        int m = matrix.length, n = matrix[0].length;
        int i=0, j=n-1;
        while (i<m && j >=0) {
            if (matrix[i][j] > target) {
                j--;
            }
            else if (matrix[i][j] < target) {
                i++;
            }
            else {
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] res = searchInMatrix(new int[][]{new int[]{1,2,5}, new int[]{3,4,6}}, 9);
        for (int r:
             res) {
            System.out.println(r);
        }

    }
}
