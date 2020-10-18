/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */

public class LastParent {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        // terminator
        if (root == null) return false;
        // process current logic
        // drill down
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        //左节点包含p 有节点包含q 或者 左右其中之一为当期节点并且 左或者右是孩子节点
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

}
