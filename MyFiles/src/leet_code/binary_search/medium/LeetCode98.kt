package leet_code.binary_search.medium

import leet_code.binarytree_general.easy.TreeNode


/**
Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys strictly less than the node's key.
The right subtree of a node contains only nodes with keys strictly greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */


/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        fun dfs(node: TreeNode?, low: Long, high: Long): Boolean {
            if (node == null) return true
            val v = node.value.toLong()
            if (v <= low || v >= high) return false
            return dfs(node.left, low, v) && dfs(node.right, v, high)
        }

        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }
}
