import java.util.Scanner;

/**
 * Created by chenjianfeng on 2017/9/19.
 */
public class baidu {
    public static double res = 0;
    public static double cal(int[] a, int i){
        if(a.length==0)
            return 0;
        else if(i==a.length-1)
            return a[i];
        else
            return a[i] + 1.0/cal(a, i+1);
    }

    public static double calLoop(int[] a){
        if(a.length==0 || a.length==1)
            return a.length==0? 0:a[0];
        double res = a[a.length-1];
        for(int i=a.length-2; i>=0; i--)
            res = 1.0/res + a[i];
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = "";
        String b = "";
        while (in.hasNextLine()) {
            a = in.nextLine();
            b = in.nextLine();
            break;
        }
        String[] x = a.split(" ");
        String[] y = b.split(" ");
        int[] xx = new int[x.length];
        int[] yy = new int[y.length];
        for(int i=0; i<x.length; i++)
            xx[i] = Integer.parseInt(x[i]);
        for(int j=0; j<y.length; j++)
            yy[j] = Integer.parseInt(x[j]);

        System.out.println(calLoop(xx));
        System.out.println(calLoop(yy));
        System.out.println(cal(xx, 0));
    }
}
