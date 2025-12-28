package leet_code.binarytree_general.medium


/**
Given a binary tree

struct Node {
int val;
Node *left;
Node *right;
Node *next;
}
Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 */


//fun connect(root: Node?): Node? {
//    var levelStart = root
//
//    while (levelStart != null) {
//        val dummy = Node(0)
//        var tail = dummy
//        var cur = levelStart
//
//        while (cur != null) {
//            cur.left?.let {
//                tail.next = it
//                tail = it
//            }
//            cur.right?.let {
//                tail.next = it
//                tail = it
//            }
//            cur = cur.next
//        }
//        levelStart = dummy.next
//    }
//    return root
//}


//fun connect(root: Node?): Node? {
//    var levelStart = root
//
//    while (levelStart != null) {
//        val dummy = Node(0)
//        var tail = dummy
//        var cur = levelStart
//
//        while (cur != null) {
//            cur.left?.let {
//                tail.next = it
//                tail = it
//            }
//            cur.right?.let {
//                tail.next = it
//                tail = it
//            }
//            cur = cur.next
//        }
//        levelStart = dummy.next
//    }
//    return root
//}
