package leet_code.binarytree_general.hard

import leet_code.binarytree_general.easy.TreeNode


/**
A path in a binary tree is a sequence of nodes where each pair of adjacent
nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once.
Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */

fun maxPathSum(root: TreeNode?): Int {
    var ans = Int.MIN_VALUE

    fun dfs(node: TreeNode?): Int {
        if (node == null) return 0

        val left = maxOf(0, dfs(node.left))
        val right = maxOf(0, dfs(node.right))

        val through = node.value + left + right
        if (through > ans) ans = through

        return node.value + maxOf(left, right)
    }

    dfs(root)
    return ans
}

