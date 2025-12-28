package leet_code.binarytree_general.medium

import leet_code.binarytree_general.easy.TreeNode


/**
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */


fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || root === p || root === q) return root
    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)
    if (left != null && right != null) return root
    return left ?: right
}

