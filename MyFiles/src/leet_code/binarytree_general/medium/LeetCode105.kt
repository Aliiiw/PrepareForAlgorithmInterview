package leet_code.binarytree_general.medium

import leet_code.binarytree_general.easy.TreeNode


/**
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is
the inorder traversal of the same tree, construct and return the binary tree.
 */


fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) return null

    val index = HashMap<Int, Int>(inorder.size)
    for (i in inorder.indices) index[inorder[i]] = i

    fun build(preL: Int, preR: Int, inL: Int, inR: Int): TreeNode? {
        if (preL > preR || inL > inR) return null

        val rootVal = preorder[preL]
        val mid = index[rootVal]!!

        val leftSize = mid - inL

        val root = TreeNode(rootVal)
        root.left = build(preL + 1, preL + leftSize, inL, mid - 1)
        root.right = build(preL + leftSize + 1, preR, mid + 1, inR)
        return root
    }

    return build(0, preorder.lastIndex, 0, inorder.lastIndex)
}

fun buildTree2(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) return null

    fun findIndex(arr: IntArray, l: Int, r: Int, x: Int): Int {
        var i = l
        while (i <= r) {
            if (arr[i] == x) return i
            i++
        }
        return -1
    }

    fun build(preL: Int, preR: Int, inL: Int, inR: Int): TreeNode? {
        if (preL > preR || inL > inR) return null

        val rootVal = preorder[preL]
        val mid = findIndex(inorder, inL, inR, rootVal)

        val leftSize = mid - inL

        val root = TreeNode(rootVal)
        root.left = build(preL + 1, preL + leftSize, inL, mid - 1)
        root.right = build(preL + leftSize + 1, preR, mid + 1, inR)
        return root
    }

    return build(0, preorder.lastIndex, 0, inorder.lastIndex)
}

