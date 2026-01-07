import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxDepthOfTree {
    
static class Node {
    Integer data;
    Node left, right;

    Node(int val)
    {
        this.data = val;
        this.left = this.right = null;
    }
}


    public static int height(Node root) {
        // code here
        if (root==null) return -1;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return 1+Math.max(leftHeight,rightHeight);
    }


    static Node constructTree(Integer [] roots)
    {
        if(roots.length==0)return null;
        Node root =new Node(roots[0]);
        Queue <Node> queue =new LinkedList<>();
        queue.offer(root);
        int idx=1;
        while(!queue.isEmpty())
        {
            Node curr=queue.poll();
            if(idx<roots.length && roots[idx]!=null)
            {
                curr.left=new Node(roots[idx]);
                queue.offer(curr.left);
            }
            idx++;
            if(idx<roots.length && roots[idx]!=null)
            {
                curr.right=new Node(roots[idx]);
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
        Node root =constructTree(roots);
       
        System.out.println("The maximum depth of the tree is:"+height(root));
    }
}
