package Day4.BinaryTree;

import com.sun.source.tree.Tree;

public class Invert {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public static TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }
    public static void Inorder(TreeNode root){
        if(root == null){
            return;
        }
        Inorder(root.left);
        System.out.print(root.val+" ");
        Inorder(root.right);
    }

    public static void main(String[] args) {
        Invert obj = new Invert();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.print("Original Tree (Inorder) ");
        obj.Inorder(root);
        obj.invertTree(root);

        System.out.print("\nInverted Tree (Inorder) ");
        obj.Inorder(root);
    }
}
