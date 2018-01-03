import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by chenjianfeng on 2017/9/28.
 */
public class Exam360 {
    public static int numsOfTriangels(double[] arr) {
        int num = 0;
        if(arr.length==0)
            return 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    double pointA = arr[i];
                    double pointB = arr[j];
                    double pointC = arr[k];
                    double pointD = pointA+180;
                    double pointE = pointB+180;
                    if(pointD>360)
                        pointD -= 360;
                    if(pointE>360)
                        pointE -= 360;
                    if(pointD>pointE && (pointC<pointE || pointC>pointD))
                        num++;
                    else if(pointE>pointD && (pointC<pointD || pointC>pointE))
                        num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) throws Exception{
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//            int n = in.nextInt();
//            double[] arr = new double[n];
//            for(int i=0; i<n; i++){
//                arr[i] = in.nextDouble();
//            }
//            System.out.println(numsOfTriangels(arr));
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        for(int i=0; i<n; i++)
            arr[i] = Double.parseDouble(br.readLine());
        System.out.println(numsOfTriangels(arr));
    }
}
