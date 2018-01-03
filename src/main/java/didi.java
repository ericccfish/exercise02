/**
 * Created by chenjianfeng on 2017/9/23.
 */
import java.util.Scanner;
public class didi {

    public static double func(double x, int n) {
        if (n == 0)
            return 1;
        return x * func(x, n - 1);
    }

    public static boolean isZero(int[][] sea, int row, int col) {
        int rows = sea.length;
        int cols = sea[0].length;
        if (row < 0 || col < 0 || row >= rows || col >= cols)
            return true;
        else if (sea[row][col] == 0)
            return true;
        return false;
    }

    public static String island(int m, int n, int[][] addLand) {
        int[][] sea = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                sea[i][j] = 0;
        }
        int[] res = new int[addLand.length];
        for (int i = 0; i < addLand.length; i++)
            res[i] = 0;
        res[0] = 1;
        sea[addLand[0][0]][addLand[0][1]] = 1;
        for (int k = 1; k < addLand.length; k++) {
            if (addLand[k][0] >= 0 && addLand[k][1] >= 0) {
                if (isZero(sea, addLand[k][0] - 1, addLand[k][1]) &&
                        isZero(sea, addLand[k][0], addLand[k][1] + 1) &&
                        isZero(sea, addLand[k][0] + 1, addLand[k][1]) &&
                        isZero(sea, addLand[k][0], addLand[k][1] - 1))
                    res[k] = res[k - 1] + 1;
                else
                    res[k] = res[k - 1];
                sea[addLand[k][0]][addLand[k][1]] = 1;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < res.length - 1; i++)
            sb.append(res[i] + " ");
        sb.append(res[res.length - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int m = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] addLand = new int[k][2];
            for(int i=0; i<k; i++){
                addLand[i][0] = in.nextInt();
                addLand[i][1] = in.nextInt();
            }
            System.out.println(island(m, n, addLand));
        }
    }
}
