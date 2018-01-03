import java.util.*;

/**
 * Created by chenjianfeng on 2017/10/10.
 */

class Tuple2{
    int first;
    int second;
    void addFirst(int val){
        this.first = val;
    }
    Tuple2(int first, int second){this.first = first; this.second = second;}
}
public class LianJia {

    public void minimumEnergy(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] toys = new int[n];
        int[][] lines = new int[n+1][n+1];
        int i = 0;
        while(in.hasNextInt())
        {
            if(i<n){
                toys[i] = in.nextInt();
                i++;
            }
            else{
                int a = in.nextInt();
                int b = in.nextInt();
                lines[a][b] = 1;
                lines[b][a] = 1;
            }
        }

        System.out.println();
    }

    public void sortNames(){
        Scanner in = new Scanner(System.in);
        LinkedList<String> names = new LinkedList<String>();
        while(in.hasNext()){
            String tmp = in.nextLine();
            if(tmp.equals("end"))
                break;
            names.add(tmp);
        }

        Collections.sort(names, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<names.size(); i++){
            sb.append(names.get(i));
            if(i!=names.size()-1)
                sb.append(",");
        }

        System.out.println(sb.toString());
    }

    public void magicScore(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        int avg = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }
        int goal = n*avg;
        int cursum = 0;
        int cost = 0;
        for(int i=0; i<n; i++)
            cursum += a[i];
        int[] visited = new int[n];
        while(cursum<goal){
            int indexOfMin = indexOfMinValue(b);
            while(cursum<goal && a[indexOfMin]+1<=r){
                a[indexOfMin] += 1;
                cursum += 1;
                cost += b[indexOfMin];
            }
            b[indexOfMin] = Integer.MAX_VALUE;
        }
        System.out.println(cost);
    }

    public void magicScore2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        int avg = in.nextInt();
        LinkedList<Tuple2> scList = new LinkedList<Tuple2>();
        for(int i=0; i<n; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            Tuple2 tmp = new Tuple2(a, b);
            scList.add(tmp);
        }
        Collections.sort(scList, new Comparator<Tuple2>() {
            public int compare(Tuple2 o1, Tuple2 o2) {
                return o1.second-o2.second;
            }
        });
        int goal = n*avg;
        int cursum = 0;
        int cost = 0;
        for(int i=0; i<n; i++)
            cursum += scList.get(i).first;
        while(cursum<goal && !scList.isEmpty()){
            while(cursum<goal && scList.get(0).first+1<=r){
                scList.get(0).addFirst(1);
                cursum += 1;
                cost += scList.get(0).second;
            }
            scList.remove(0);
        }
        System.out.println(cost);
    }
    public int indexOfMinValue(int[] b){
        if(b.length<=1)
            return 0;
        int indexOfMin = 0;
        for(int i=1; i<b.length; i++){
            if(b[i]<=b[indexOfMin])
                indexOfMin = i;
        }
        return indexOfMin;
    }

    public int indexOfMinValue2(int[] b, int[] visited){
        if(b.length<=1)
            return 0;
        int indexOfMin = 0;
        for(int i=0; i<b.length; i++){
            if(visited[i]!=1)
                indexOfMin = i;
            break;
        }
        for(int i=0; i<b.length; i++){
            if(visited[i]!=1 && b[i]<=b[indexOfMin])
                indexOfMin = i;
        }
        return indexOfMin;
    }

    public static void main(String[] args) throws Exception{
        LianJia lj = new LianJia();
//        lj.sortNames();
        lj.magicScore();
    }
}
//5 5 4
//5 2
//4 7
//3 1
//3 2
//2 5