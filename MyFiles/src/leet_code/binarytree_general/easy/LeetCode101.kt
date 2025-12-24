package leet_code.binarytree_general.easy


/**
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */


fun isSymmetric(root: TreeNode?): Boolean {
    fun isMirror(a: TreeNode?, b: TreeNode?): Boolean {
        if (a == null && b == null) return true
        if (a == null || b == null) return false
        if (a.value != b.value) return false
        return isMirror(a.left, b.right) && isMirror(a.right, b.left)
    }

    return isMirror(root?.left, root?.right)
}

fun isSymmetric2(root: TreeNode?): Boolean {
    val dq = ArrayDeque<TreeNode?>()
    dq.addLast(root?.left)
    dq.addLast(root?.right)

    while (dq.isNotEmpty()) {
        val a = dq.removeFirst()
        val b = dq.removeFirst()

        if (a == null && b == null) continue
        if (a == null || b == null) return false
        if (a.value != b.value) return false

        dq.addLast(a.left)
        dq.addLast(b.right)
        dq.addLast(a.right)
        dq.addLast(b.left)
    }

    return true
}


