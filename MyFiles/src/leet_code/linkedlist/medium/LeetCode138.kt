package leet_code.linkedlist.medium

import leet_code.linkedlist.easy.ListNode


/*
A linked list of length n is given such that each node contains an additional random pointer,
which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
where each new node has its value set to the value of its corresponding original node.
Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers
in the original list and copied list represent the same list state. None of the pointers in the new list should point
to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two
nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair
 of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does
not point to any node.
Your code will only be given the head of the original linked list.

  Example:
  var ti = Node(5)
  var v = ti.`val`
  Definition for a Node.
  class Node(var `val`: Int) {
      var next: Node? = null
      var random: Node? = null
  }

 */

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

fun copyRandomList(head: Node?): Node? {
    if (head == null) return null

    val map = HashMap<Node, Node>()

    var cur: Node? = head
    while (cur != null) {
        map[cur] = Node(cur.`val`)
        cur = cur.next
    }

    cur = head
    while (cur != null) {
        val copy = map[cur]!!
        copy.next = map[cur.next]
        copy.random = map[cur.random]
        cur = cur.next
    }

    return map[head]
}


fun copyRandomList2(head: Node?): Node? {
    if (head == null) return null

    var cur: Node? = head
    while (cur != null) {
        val copy = Node(cur.`val`)
        copy.next = cur.next
        cur.next = copy
        cur = copy.next
    }

    cur = head
    while (cur != null) {
        val copy = cur.next!!
        copy.random = cur.random?.next
        cur = copy.next
    }

    val copiedHead = head.next
    cur = head
    while (cur != null) {
        val copy = cur.next!!
        cur.next = copy.next
        copy.next = copy.next?.next
        cur = cur.next
    }

    return copiedHead
}
