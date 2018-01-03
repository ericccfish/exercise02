import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by chenjianfeng on 2017/9/17.
 */

public class SouHu {
    public static void tt2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }

    public static String simplyUnixPath(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strList = str.split("/");
        Stack<String> stack = new Stack();
        for(String s: strList){
            if(s.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
                else
                    continue;
            }
            else if(s.equals(".") || s.length()==0)
                continue;
            else
                stack.push(s);
        }

        StringBuffer sb = new StringBuffer();
        ArrayList<String> res = new ArrayList<String>();
        while(!stack.isEmpty())
            res.add(0,stack.pop());
        for(int i=0; i<res.size(); i++){
            sb.append("/"+res.get(i));
        }
        if(sb.length()==0)
            sb.append("/");
        return sb.toString();
    }

    public static void question2(){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int[len];
        for(int i=0; i<len; i++)
            arr[i] = in.nextInt();

    }
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//        tt2();
        System.out.println(simplyUnixPath());
    }
}