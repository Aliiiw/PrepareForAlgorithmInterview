package leet_code.divide_conquer.easy

import leet_code.binarytree_general.easy.TreeNode


/**
Given an integer array nums where the elements are sorted in ascending order,
convert it to a height-balanced binary search tree.

Height-Balanced
A height-balanced binary tree is a binary tree in which the depth of
the two subtrees of every node never differs by more than one.
 */

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    fun build(l: Int, r: Int): TreeNode? {
        if (l > r) return null
        val mid = l + (r - l) / 2
        val root = TreeNode(nums[mid])
        root.left = build(l, mid - 1)
        root.right = build(mid + 1, r)
        return root
    }

    return build(0, nums.lastIndex)
}

fun sortedArrayToBST2(nums: IntArray): TreeNode? {
    fun build(l: Int, r: Int): TreeNode? {
        if (l > r) return null
        val mid = l + (r - l + 1) / 2
        val root = TreeNode(nums[mid])
        root.left = build(l, mid - 1)
        root.right = build(mid + 1, r)
        return root
    }

    return build(0, nums.lastIndex)
}
