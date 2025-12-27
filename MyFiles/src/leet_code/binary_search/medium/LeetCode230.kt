package leet_code.binary_search.medium

import leet_code.binarytree_general.easy.TreeNode

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
//class Solution {
//
//    var result: Int? = null
//    var k: Int? = null
//
//    fun kthSmallest(root: TreeNode?, k: Int): Int {
//        this.k = k
//        solution(root)
//        return result!!
//    }
//
//    fun solution(root: TreeNode?) {
//        if (root == null) return
//
//        solution(root.left)
//
//        k = k?.minus(1)
//        if (k == 0) {
//            result = root.value
//        }
//
//        solution(root.right)
//    }
//}

