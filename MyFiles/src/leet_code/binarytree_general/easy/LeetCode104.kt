package leet_code.binarytree_general.easy

import kotlin.math.max


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

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun maxDepth(root: TreeNode?): Int {

    if (root == null) return 0

    val left = maxDepth(root.left)
    val right = maxDepth(root.right)

    return max(left, right) + 1
}