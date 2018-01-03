import java.util.Scanner;
import java.util.Stack;

/**
 * Created by chenjianfeng on 2017/10/14.
 */
public class AiQiYi {
    public static boolean isPowerOfN(int n, int target){
        if(target==0)
            return false;
        else if(target==1)
            return true;
        return isPowerOfN(n, target/n);
    }
    public static boolean niuWin(int n, int target){
        if(target==1)
            return true;
        double maxFactor = Math.sqrt(target);
        int mf = (int)Math.floor(maxFactor);
        return niuWin(n, target-mf);
    }
    public static void quesOne(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            int target = in.nextInt();
            if(niuWin(4, target) || isPowerOfN(4, target))
                System.out.println("niu");
            else
                System.out.println("yang");
        }
    }

    public static int update(int a, int b, int ans){
        return (a^b)>ans?(a^b):ans;
    }

    public static void quesTwo2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 0;
        Stack<Integer> st = new Stack();
        st.push(in.nextInt());
        for(int i=1; i<n; i++){
            int next = in.nextInt();
            while(!st.isEmpty() && st.peek()<=next){
                max = update(st.peek(), next, max);
                st.pop();
            }
            if(!st.isEmpty())
                max = update(st.peek(), next, max);
            st.push(next);
        }
        System.out.println(max);
    }
    public static void quesTwo(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for(int i=0; i<n; i++)
            arr[i] = in.nextInt();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if((arr[i]^arr[j])>max)
                    max = arr[i]^arr[j];
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args){
//        quesOne();
        quesTwo2();
    }
}
