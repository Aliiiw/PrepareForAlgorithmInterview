package leet_code.binarytree_general.easy


/**
Given the root of a binary tree, invert the tree, and return its root.
 */


fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    val left = invertTree(root.left)
    val right = invertTree(root.right)

    root.left = right
    root.right = left

    return root
}

