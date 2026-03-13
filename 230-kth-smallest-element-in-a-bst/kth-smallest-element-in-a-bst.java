/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null) {
      stack.push(root);
      root=root.left;
    }

    for (int i = 0; i < k - 1; ++i) {
      root = stack.pop();
      root = root.right;
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
    }

    return stack.peek().val;
  }
}