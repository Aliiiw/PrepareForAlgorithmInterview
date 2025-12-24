package leet_code.binarytree_general.easy


/**
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */


import java.util.*

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false
    if (p.value != q.value) return false
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
}

fun isSameTree2(p: TreeNode?, q: TreeNode?): Boolean {
    val dq = ArrayDeque<TreeNode?>()
    dq.addLast(p)
    dq.addLast(q)

    while (dq.isNotEmpty()) {
        val a = dq.removeFirst()
        val b = dq.removeFirst()

        if (a == null && b == null) continue
        if (a == null || b == null) return false
        if (a.value != b.value) return false

        dq.addLast(a.left)
        dq.addLast(b.left)
        dq.addLast(a.right)
        dq.addLast(b.right)
    }

    return true
}

