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

    
}
