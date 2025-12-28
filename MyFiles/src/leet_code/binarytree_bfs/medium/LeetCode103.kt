package leet_code.binarytree_bfs.medium

import leet_code.binarytree_general.easy.TreeNode


/**
Given the root of a binary tree, return the zigzag level order traversal
of its nodes' values. (i.e., from left to right,
then right to left for the next level and alternate between).
 */

fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val res = ArrayList<List<Int>>()
    val q = ArrayDeque<TreeNode>()
    q.addLast(root)
    var leftToRight = true

    while (q.isNotEmpty()) {
        val size = q.size
        val level = IntArray(size)

        for (i in 0 until size) {
            val node = q.removeFirst()
            val idx = if (leftToRight) i else size - 1 - i
            level[idx] = node.value

            node.left?.let { q.addLast(it) }
            node.right?.let { q.addLast(it) }
        }

        res.add(level.toList())
        leftToRight = !leftToRight
    }

    return res
}

