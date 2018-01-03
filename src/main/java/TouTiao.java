import java.util.Scanner;

/**
 * Created by chenjianfeng on 2017/10/17.
 */
public class TouTiao {
    public static int backIndex(int idx, int n){
        if(idx==0)
            return n-1;
        return idx-1;
    }

    public static int nextIndex(int idx, int n){
        if(idx==n-1)
            return 0;
        return idx+1;
    }

    public static int[] forward(int[] rooms, int n, int start){
        int people = rooms[start];
        int nextIdx = nextIndex(start, n);
        while(people>0){
            rooms[start]--;
            rooms[nextIdx] += 1;
            people--;
            nextIdx = nextIndex(nextIdx, n);
        }
        return rooms;
    }

    public static int satisfyCondition(int[] origin, int[] rooms, int n, int outsidePeople){
        boolean flag = true;
        int[] copy = new int[n];
        for(int k=0; k<n; k++)
            copy[k] = rooms[k];
        for(int i=0; i<n; i++) {
            if (copy[i] == 0) {
                copy[i] = outsidePeople;
                int[] allocated = forward(copy, n, i);
                for(int k=0; k<n; k++){
                    if(allocated[k]!=origin[k]) {
                        copy[i] = 0;
                        flag = false;
                        break;
                    }
                }
                if(flag) return i;
            }
        }
        return -1;
    }
    public static void allocateRoom(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int lastNum = in.nextInt();
        int[] origin = new int[n];
        int[] rooms = new int[n];
        for(int i=0; i<n; i++) {
            origin[i] = in.nextInt();
            rooms[i] = origin[i];
        }
        int outsidePeople = 0;
        int idx = lastNum-1;
        int times = 4;
        while(times-- > 0){
            rooms[idx]--;
            System.out.println(idx + " " +rooms[idx]);
            outsidePeople++;
            int ans = satisfyCondition(origin, rooms, n, outsidePeople);
            if(ans != -1) {
                rooms[ans] = outsidePeople;
                StringBuffer sb = new StringBuffer();
                for(int x=0; x<n; x++) {
                    sb.append(rooms[x]);
                    if(x!=n-1)
                        sb.append(" ");
                }
                System.out.println(sb.toString());
                break;
            }
            idx = backIndex(idx, n);
        }
    }

    public static void main(String[] args){
        allocateRoom();
    }
}
