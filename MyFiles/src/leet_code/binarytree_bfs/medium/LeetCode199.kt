package leet_code.binarytree_bfs.medium

import leet_code.binarytree_general.easy.TreeNode


/**
Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.
 */

fun rightSideView(root: TreeNode?): List<Int> {
    val res = ArrayList<Int>()

    fun dfs(node: TreeNode?, depth: Int) {
        if (node == null) return
        if (depth == res.size) res.add(node.value)
        dfs(node.right, depth + 1)
        dfs(node.left, depth + 1)
    }

    dfs(root, 0)
    return res
}
