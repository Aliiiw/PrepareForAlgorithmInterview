package leet_code.binarytree_bfs.medium

import leet_code.binarytree_general.easy.TreeNode


/**
Given the root of a binary tree, return the
level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */

fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val res = ArrayList<List<Int>>()
    val q = ArrayDeque<TreeNode>()
    q.addLast(root)

    while (q.isNotEmpty()) {
        val size = q.size
        val level = ArrayList<Int>(size)

        repeat(size) {
            val node = q.removeFirst()
            level.add(node.value)
            node.left?.let { q.addLast(it) }
            node.right?.let { q.addLast(it) }
        }

        res.add(level)
    }

    return res
}

fun levelOrder2(root: TreeNode?): List<List<Int>> {
    val res = ArrayList<MutableList<Int>>()

    fun dfs(node: TreeNode?, depth: Int) {
        if (node == null) return
        if (depth == res.size) res.add(ArrayList())
        res[depth].add(node.value)
        dfs(node.left, depth + 1)
        dfs(node.right, depth + 1)
    }

    dfs(root, 0)
    return res
}
