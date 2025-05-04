package codepractice.trees;

import org.w3c.dom.Node;

public class DiameterOFTree {

   /* private static int height(Node root,int[] ans){
        if(root==null)return 0;
        int left=height(root.left,ans);
        int right=height(root.right,ans);
        ans[0]=Math.max(ans[0],left+right);
        return Math.max(left,right)+1;
    }
    private static int diameter(Node root) {
        int maxDiameter[]=new int[1];
        height(root,maxDiameter);
        return maxDiameter[0];
    }

    public static void main(String[] args) {
           int[] root=new int [3]{1, 2, 3};
           height(root,0);
    }*/
}
