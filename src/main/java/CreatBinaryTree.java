import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chenjianfeng on 2017/9/14.
 */

class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int x){
        this.val = x;
    }
}

public class CreatBinaryTree {
    public static int preCounter = 0;
    public static int inCounter = 0;
    public static int postCounter = 0;

    public static Stack<TreeNode> inStack = new Stack();
    public static Queue<TreeNode> postQueue = new LinkedList<TreeNode>();

    public TreeNode creatTreeInPreOrder(TreeNode root, int[] arr, int i){
        if(i<arr.length){
            if(arr[i]==-1)
                return null;
            else{
                root = new TreeNode(arr[i]);
                root.left = creatTreeInPreOrder(root.left, arr, ++preCounter);
                root.right = creatTreeInPreOrder(root.right, arr, ++preCounter);
            }
        }
        return root;
    }

    public TreeNode creatTreeInInOrder(TreeNode root, int[] arr, int i){
        if(i<arr.length){
            if(inStack.size()!=0){
                if(arr[i]==-1)
                    root = null;
                else
                    root = new TreeNode(arr[i]);
                root.left = inStack.pop();
                root.right = creatTreeInInOrder(root.right, arr, ++inCounter);
                inStack.push(root);
            }
            else{
                if(arr[i]==-1)
                    inStack.push(null);
                else
                    inStack.push(new TreeNode(arr[inCounter]));
                root = creatTreeInInOrder(root, arr, ++inCounter);
            }
        }
        else if(inStack.size()!=0)
            root = inStack.pop();
        return root;
    }

    public TreeNode creatTreeInPostOrder(TreeNode root, int[] arr, int i){
        if(i<arr.length){
            if(i==arr.length-1){
                if(arr[i]==-1)
                    return null; // 非法
                else
                    root = new TreeNode(arr[i]);
                if(!postQueue.isEmpty())
                    root.left = postQueue.poll();
                if(!postQueue.isEmpty())
                    root.right = postQueue.poll();
                return root;
            }
            if(postQueue.size()!=2) {
                if(arr[i]==-1)
                    postQueue.offer(null);
                else{
                    root = new TreeNode(arr[i]);
                    postQueue.offer(root);
                }
            }
            else{
                if(arr[i]==-1)
                    return null;            // 不合法输入
                root = new TreeNode(arr[i]);
                root.left = postQueue.poll();
                root.right = postQueue.poll();
                postQueue.offer(root);
            }
            return creatTreeInPostOrder(root, arr, ++postCounter);
        }
        return root;
    }


    public void printTreeInPreOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.val+" ");
            printTreeInPreOrder(root.left);
            printTreeInPreOrder(root.right);
        }
        else
            System.out.print("# ");
    }

    public void printTreeInInOrder(TreeNode root){
        if(root!=null){
            printTreeInInOrder(root.left);
            System.out.print(root.val+" ");
            printTreeInInOrder(root.right);
        }
        else
            System.out.print("# ");
    }

    public void printTreeInPostOrder(TreeNode root){
        if(root!=null){
            printTreeInPostOrder(root.left);
            printTreeInPostOrder(root.right);
            System.out.print(root.val+" ");
        }
        else
            System.out.print("# ");
    }

    public static void main(String[] args) throws Exception{
        CreatBinaryTree cbt = new CreatBinaryTree();
        int[] preArr = new int[]{1,2,3,-1,4,-1,-1,-1,5};
        TreeNode preHead = null;
        preHead = cbt.creatTreeInPreOrder(preHead, preArr, 0);
        System.out.println("pre order:");
        cbt.printTreeInPreOrder(preHead);

        int[] inArr = new int[]{-1,3,-1,4,-1,2,-1,1,-1,5,-1};
        TreeNode inHead = null;
        inHead = cbt.creatTreeInInOrder(inHead, inArr, 0);
        System.out.println("\nin order:");
        cbt.printTreeInInOrder(inHead);

//        int[] postArr = new int[]{-1,-1,3,-1,-1,2,4,-1,-1,5,1};
        int[] postArr = new int[]{-1,-1,3,-1,2};
        TreeNode postHead = null;
        postHead = cbt.creatTreeInPostOrder(postHead, postArr, 0);
        System.out.println("\npost order:");
        cbt.printTreeInPostOrder(postHead);
    }
}
