package Day4.BinaryTree;

public class LCA {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}
    }

    static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        if(root==q || root==p){
            return root;
        }
        TreeNode left = lca(root.left,p,q);
        TreeNode right = lca(root.right,p,q);

        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else{
            return root;
        }
    }
}