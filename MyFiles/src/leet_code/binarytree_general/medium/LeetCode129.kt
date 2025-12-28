package leet_code.binarytree_general.medium

import com.sun.source.tree.Tree
import leet_code.binarytree_general.easy.TreeNode


/**
You are given the root of a binary tree containing digits from 0 to 9 only

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated
so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.
 */


fun main() {
    fun n(v: Int, l: TreeNode? = null, r: TreeNode? = null): TreeNode {
        val t = TreeNode(v)
        t.left = l
        t.right = r
        return t
    }

    val t1 = n(1, n(2), n(3))
    val a1 = sumNumbers(t1)
    check(a1 == 25) { "Expected 25, got $a1" }

    val t2 = n(4, n(9, n(5), n(1)), n(0))
    val a2 = sumNumbers(t2)
    check(a2 == 1026) { "Expected 1026, got $a2" }

    val t3 = n(0)
    val a3 = sumNumbers(t3)
    check(a3 == 0) { "Expected 0, got $a3" }

    val t4 = n(0, n(1), n(2))
    val a4 = sumNumbers(t4)
    check(a4 == 3) { "Expected 3, got $a4" }

    val t5 = n(9, n(0, n(5), null), null)
    val a5 = sumNumbers(t5)
    check(a5 == 905) { "Expected 905, got $a5" }
}


fun sumNumbers(root: TreeNode?): Int {
    fun dfs(node: TreeNode?, current: Int): Int {
        if (node == null) return 0

        val nextNumber = 10 * current + node.value
        if (node.left == null && node.right == null) return nextNumber

        return dfs(node.left, nextNumber) + dfs(node.right, nextNumber)
    }

    return dfs(root, 0)
}

