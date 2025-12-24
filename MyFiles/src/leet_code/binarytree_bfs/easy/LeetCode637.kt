package leet_code.binarytree_bfs.easy

import leet_code.binarytree_general.easy.TreeNode
import java.util.*

/**
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
Answers within 10-5 of the actual answer will be accepted.
 */

fun averageOfLevels(root: TreeNode?): DoubleArray {
    if (root == null) return doubleArrayOf()

    val result = ArrayList<Double>()
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)

    while (queue.isNotEmpty()) {
        val size = queue.size
        var sum = 0L

        repeat(size) {
            val node = queue.removeFirst()
            sum += node.value
            node.left?.let { queue.addLast(it) }
            node.right?.let { queue.addLast(it) }
        }

        result.add(sum.toDouble() / size)
    }

    return result.toDoubleArray()
}


fun averageOfLevels2(root: TreeNode?): DoubleArray {
    val sums = ArrayList<Long>()
    val counts = ArrayList<Int>()

    fun dfs(node: TreeNode?, level: Int) {
        if (node == null) return

        if (level == sums.size) {
            sums.add(0L)
            counts.add(0)
        }

        sums[level] += node.value
        counts[level]++

        dfs(node.left, level + 1)
        dfs(node.right, level + 1)
    }

    dfs(root, 0)

    val result = DoubleArray(sums.size)
    for (i in sums.indices) {
        result[i] = sums[i].toDouble() / counts[i]
    }

    return result
}
