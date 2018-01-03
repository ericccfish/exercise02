import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by chenjianfeng on 2017/10/11.
 */
public class Qunar {
    public static int lcs(String a, String b){
        if(a.length()==0 || b.length()==0)
            return 0;
        int len1 = a.length();
        int len2 = b.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                if(a.charAt(i-1)==b.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[len1][len2];
    }

    public static String reverseString(String str){
        String[] strs = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i=strs.length-1; i>=0; i--){
            sb.append(strs[i]);
            if(i!=0)
                sb.append(" ");
        }
        return sb.toString();
    }

    private int num = 0;
    public void flyToNext(HashMap<String, LinkedList<String>> src2dsts, String src, String dst,
                                 LinkedList<Integer> res, int maxLines){
        if(this.num>=maxLines || !src2dsts.containsKey(src)) {
            return;
        }
        if(src2dsts.get(src).contains(dst)) {
            res.add(++this.num);
        }
        for(int i=0; i<src2dsts.get(src).size(); i++){
            this.num ++;
            flyToNext(src2dsts, src2dsts.get(src).get(i), dst, res, maxLines);
            this.num --;
        }
    }

    public static int getMin(LinkedList<Integer> res){
        if(res.size()==0)
            return -1;
        int min = res.get(0);
        for(int i=1; i<res.size(); i++){
            if(res.get(i)<min)
                min = res.get(i);
        }
        return min;
    }

    public static void question1(){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strs = line.split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        String src = strs[2];
        String dst = strs[3];
        HashMap<String, LinkedList<String>> src2dsts = new HashMap<String, LinkedList<String>>();
        for(int i=0; i<m; i++){
            strs = in.nextLine().split(" ");
            if(src2dsts.containsKey(strs[0]))
                src2dsts.get(strs[0]).add(strs[1]);
            else{
                LinkedList<String> dsts = new LinkedList<String>();
                dsts.add(strs[1]);
                src2dsts.put(strs[0], dsts);
            }
        }
        LinkedList<Integer> res = new LinkedList<Integer>();
        Qunar qunar = new Qunar();
        qunar.flyToNext(src2dsts, src, dst, res, m);
        System.out.println(getMin(res));
    }

    public void question2(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String a = in.nextLine();
            String b = reverseString(a);
            System.out.println(lcs(a, b));
        }
    }

    public static void main(String[] args) throws Exception{
        Qunar qunar = new Qunar();
//        qunar.question2();
        qunar.question1();
    }
}


//5 5 LuoYang JinLing
//ChangAn LuoYang
//LuoYang JianKang
//LuoYang LangYe
//JianKang LangYe
//JianKang JinLing