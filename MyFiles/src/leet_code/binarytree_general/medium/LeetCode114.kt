package leet_code.binarytree_general.medium

import leet_code.binarytree_general.easy.TreeNode


/**
Given the root of a binary tree, flatten the tree into a "linked list"
The "linked list" should use the same TreeNode class where the right child pointer points
to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */


fun flatten(root: TreeNode?) {
    if (root == null) return

    val list = ArrayList<TreeNode>()

    fun dfs(node: TreeNode?) {
        if (node == null) return
        list.add(node)
        dfs(node.left)
        dfs(node.right)
    }

    dfs(root)

    for (i in 0 until list.size - 1) {
        val cur = list[i]
        cur.left = null
        cur.right = list[i + 1]
    }
    list.last().left = null
    list.last().right = null
}

fun flatten2(root: TreeNode?) {
    var cur = root
    while (cur != null) {
        val left = cur.left
        if (left != null) {
            var pre = left
            while (pre?.right != null) pre = pre.right
            pre?.right = cur.right
            cur.right = left
            cur.left = null
        }
        cur = cur.right
    }
}
