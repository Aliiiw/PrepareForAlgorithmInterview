package leet_code.binarytree_general.easy


/**
Given the root of a binary tree and an integer targetSum, return true if the
tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.
 */


fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false
    val remaining = targetSum - root.value

    if (root.right == null && root.left == null) return remaining == 0

    return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining)

}

