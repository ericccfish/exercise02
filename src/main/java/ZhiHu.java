import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenjianfeng on 2017/10/25.
 */

//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//
//    }
//}

public class ZhiHu {
    public ArrayList<ArrayList<Integer>> eachRow(TreeNode pRoot) {
        if(pRoot==null)
            return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> oddQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> evenQueue = new LinkedList<TreeNode>();
        oddQueue.offer(pRoot);
        while(!oddQueue.isEmpty() || !evenQueue.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            if(!oddQueue.isEmpty()){
                while(!oddQueue.isEmpty()){
                    TreeNode pNode = oddQueue.poll();
                    tmp.add(pNode.val);
                    if(pNode.left!=null)
                        evenQueue.offer(pNode.left);
                    if(pNode.right!=null)
                        evenQueue.offer(pNode.right);
                }
            }else if(!evenQueue.isEmpty()){
                while(!evenQueue.isEmpty()){
                    TreeNode pNode = evenQueue.poll();
                    tmp.add(pNode.val);
                    if(pNode.left!=null)
                        oddQueue.offer(pNode.left);
                    if(pNode.right!=null)
                        oddQueue.offer(pNode.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public ArrayList<Double> getAverage(ArrayList<ArrayList<Integer>> rows){
        ArrayList<Double> res = new ArrayList<Double>();
        for(ArrayList row: rows){
            int sum = 0;
            for(int i=0; i<row.size(); i++){
                sum += (Integer)row.get(i);
            }
            res.add(1.0*sum/row.size());
        }
        return res;
    }

    public TreeNode insertNode(TreeNode pRoot, int val){
        if(pRoot==null)
            return new TreeNode(val);
        if(val<pRoot.val){
            pRoot.left = insertNode(pRoot.left, val);
        }else{
            pRoot.right = insertNode(pRoot.right, val);
        }
        return pRoot;
    }

    public int find_target(int[] arr, int target){
        if(arr.length==0)
            return -1;
        int left = 0;
        int right = arr.length-1;
        while(left<right && arr[left]<=target){
            if(arr[left]==target)
                return left;
            left++;
        }
        while(left<right && arr[right]>=target){
            if(arr[right]==target)
                return right;
            right--;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20);
        TreeNode ll = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        root.left = l;
        root.right = r;
        l.left = ll;
        r.right = rr;

        ZhiHu zh = new ZhiHu();
        ArrayList<ArrayList<Integer>> rows = zh.eachRow(root);
        ArrayList<Double> result = zh.getAverage(rows);
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
