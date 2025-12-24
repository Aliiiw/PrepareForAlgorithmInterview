package leet_code.binarytree_general.medium

import leet_code.binarytree_general.easy.TreeNode


/**
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder
is the postorder traversal of the same tree, construct and return the binary tree.
 */


fun buildTree106(inorder: IntArray, postorder: IntArray): TreeNode? {
    if (inorder.isEmpty()) return null

    val index = HashMap<Int, Int>(inorder.size)
    for (i in inorder.indices) index[inorder[i]] = i

    var postIdx = postorder.lastIndex

    fun build(inL: Int, inR: Int): TreeNode? {
        if (inL > inR) return null

        val rootVal = postorder[postIdx]
        postIdx--

        val mid = index[rootVal]!!
        val root = TreeNode(rootVal)

        root.right = build(mid + 1, inR)
        root.left = build(inL, mid - 1)

        return root
    }

    return build(0, inorder.lastIndex)
}

fun buildTree1062(inorder: IntArray, postorder: IntArray): TreeNode? {
    if (inorder.isEmpty()) return null

    fun findIndex(arr: IntArray, l: Int, r: Int, x: Int): Int {
        var i = l
        while (i <= r) {
            if (arr[i] == x) return i
            i++
        }
        return -1
    }

    var postIdx = postorder.lastIndex

    fun build(inL: Int, inR: Int): TreeNode? {
        if (inL > inR) return null

        val rootVal = postorder[postIdx]
        postIdx--

        val mid = findIndex(inorder, inL, inR, rootVal)
        val root = TreeNode(rootVal)

        root.right = build(mid + 1, inR)
        root.left = build(inL, mid - 1)

        return root
    }

    return build(0, inorder.lastIndex)
}

