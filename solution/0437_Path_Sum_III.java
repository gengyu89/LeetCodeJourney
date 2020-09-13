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
    private int result;
    private HashMap<Integer, Integer> cache;

    public int pathSum(TreeNode root, int sum) {
        result = 0;
        cache = new HashMap<Integer, Integer>();
        cache.put(0, 1);
        pathSumHelper(root, sum, 0);
        return result;
    }
    
    private void pathSumHelper(TreeNode root, int target, int soFar) {
        if (root != null) {
            int complement = soFar + root.val - target;
            if (cache.containsKey(complement))
                result += cache.get(complement);
            cache.put(soFar + root.val, cache.getOrDefault(soFar + root.val, 0) + 1);
            pathSumHelper(root.left, target, soFar + root.val);
            pathSumHelper(root.right, target, soFar + root.val);
            cache.put(soFar + root.val, cache.get(soFar + root.val) - 1);
        }
    }
}
