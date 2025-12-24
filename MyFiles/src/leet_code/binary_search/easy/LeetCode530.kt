package leet_code.binary_search.easy

import leet_code.binarytree_general.easy.TreeNode
import java.util.*


/**
Given the root of a Binary Search Tree (BST), return the minimum absolute
difference between the values of any two different nodes in the tree.
 */

fun getMinimumDifference(root: TreeNode?): Int {
    var prev: Int? = null
    var ans = Int.MAX_VALUE

    fun inorder(node: TreeNode?) {
        if (node == null) return
        inorder(node.left)

        val v = node.value
        if (prev != null) {
            val diff = v - prev!!
            if (diff < ans) ans = diff
        }
        prev = v

        inorder(node.right)
    }

    inorder(root)
    return ans
}

fun getMinimumDifference2(root: TreeNode?): Int {
    val stack = ArrayDeque<TreeNode>()
    var cur = root
    var prev: Int? = null
    var ans = Int.MAX_VALUE

    while (cur != null || stack.isNotEmpty()) {
        while (cur != null) {
            stack.addLast(cur)
            cur = cur.left
        }

        val node = stack.removeLast()
        val v = node.value

        if (prev != null) {
            val diff = v - prev!!
            if (diff < ans) ans = diff
        }
        prev = v

        cur = node.right
    }

    return ans
}

