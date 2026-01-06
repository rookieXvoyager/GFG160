import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(){}
    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
public class KthLargestSumInBinaryTree2583 {
     public static long kthLargestLevelSum(TreeNode root, int k) {
       
        ArrayList <Long> lvlSum=new ArrayList<>();
        Queue <TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            long currSum=0;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=queue.poll();
                currSum+=curr.val;
                if(curr.left!=null)queue.offer(curr.left);
                if(curr.right!=null)queue.offer(curr.right);
            }
            lvlSum.add(currSum);
        }

        Collections.sort(lvlSum);
        return k>lvlSum.size()?-1:lvlSum.get(lvlSum.size()-k);
    }

    static TreeNode constructTree(Integer [] roots)
    {
        if(roots.length==0)return null;
        TreeNode root =new TreeNode(roots[0]);
        Queue <TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        int idx=1;
        while(!queue.isEmpty())
        {
            TreeNode curr=queue.poll();
            if(idx<roots.length && roots[idx]!=null)
            {
                curr.left=new TreeNode(roots[idx]);
                queue.offer(curr.left);
            }
            idx++;
            if(idx<roots.length && roots[idx]!=null)
            {
                curr.right=new TreeNode(roots[idx]);
                queue.offer(curr.right);
            }
            idx++;
        }
        return root;

    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter tree node values seperated by space:");
        String [] inp =sc.nextLine().split(" ");
        Integer [] roots =new Integer[inp.length];
        int index=0;
        for(String str:inp)
        {
            if(str.equalsIgnoreCase("null"))
            {
                roots[index++]=null;
            }else{
                roots[index++]=Integer.parseInt(str);
            }
        }
        TreeNode root =constructTree(roots);
        System.out.println("Enter the value of k:");
        int k=sc.nextInt();
        System.out.println("The "+k+"th largest level sum of the tree is:"+kthLargestLevelSum(root,k));
    }
}
