package com.xp.solutions._951_Flip_Equivalent_Binary_Trees;

/**
 * @author yukong
 * @date 2019-05-28 14:07
 */
public class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null){
            return true;
        }else if( (root1 == null && root2 != null)
                || (root1 != null && root2 == null)){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }

        if((flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right)) ||
                (flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left))){
            return true;
        }else{
            return false;
        }
    }

}
