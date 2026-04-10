package Day4.BinaryTree;

import java.util.*;

public class VerticalOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static List<List<Integer>> vertical(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        q.add(root);
        cols.add(0);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);

            if (node.left != null) {
                q.add(node.left);
                cols.add(col - 1);
            }

            if (node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
            }
        }

        res.addAll(map.values());

        return res;
    }

    public static void main(String[] args) {



        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        List<List<Integer>> result = vertical(root);

        System.out.println(result);
    }
}