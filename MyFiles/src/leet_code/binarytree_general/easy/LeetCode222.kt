package leet_code.binarytree_general.easy


/**
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a
complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes
inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.
 */


fun countNodes(root: TreeNode?): Int {
    if (root == null) return 0
    return 1 + countNodes(root.left) + countNodes(root.right)
}

fun countNodes2(root: TreeNode?): Int {
    fun leftHeight(node: TreeNode?): Int {
        var h = 0
        var cur = node
        while (cur != null) {
            h++
            cur = cur.left
        }
        return h
    }

    fun rightHeight(node: TreeNode?): Int {
        var h = 0
        var cur = node
        while (cur != null) {
            h++
            cur = cur.right
        }
        return h
    }

    fun dfs(node: TreeNode?): Int {
        if (node == null) return 0
        val lh = leftHeight(node)
        val rh = rightHeight(node)
        if (lh == rh) return (1 shl lh) - 1
        return 1 + dfs(node.left) + dfs(node.right)
    }

    return dfs(root)
}


