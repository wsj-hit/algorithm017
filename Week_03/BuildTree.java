import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private HashMap<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, n - 1, 0, n - 1);

    }

    public TreeNode myBuildTree(int[] preorder, int ls, int le, int rs, int re) {
        if (ls > le) {
            return null;
        }

        //中序便利中定位根节点
        Integer inRoot = indexMap.get(preorder[ls]);
        //建立根节点
        TreeNode root = new TreeNode(preorder[ls]);
        //左子树节点数目
        int lSize = inRoot - rs;
        root.left = myBuildTree(preorder, ls + 1, ls + lSize, rs, inRoot - 1);
        root.right = myBuildTree(preorder, ls + lSize + 1, le, inRoot + 1, re);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //[3,9,20,15,7]
        //[9,3,15,20,7]
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        solution.buildTree(pre,in);
    }
}