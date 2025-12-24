package leet_code.linkedlist.medium

import leet_code.linkedlist.easy.ListNode


/*
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */


fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var p1 = l1
    var p2 = l2
    var carry = 0

    val dummy = ListNode(0)
    var tail = dummy

    while (p1 != null || p2 != null || carry != 0) {
        val x = p1?.`val` ?: 0
        val y = p2?.`val` ?: 0

        val sum = x + y + carry
        carry = sum / 10

        tail.next = ListNode(sum % 10)
        tail = tail.next!!

        p1 = p1?.next
        p2 = p2?.next
    }

    return dummy.next
}

fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
    fun digit(node: ListNode?): Int = node?.`val` ?: 0

    var p1 = l1
    var p2 = l2
    var carry = 0

    val dummy = ListNode(0)
    var tail = dummy

    while (p1 != null || p2 != null || carry != 0) {
        val sum = digit(p1) + digit(p2) + carry
        carry = sum / 10

        tail.next = ListNode(sum % 10)
        tail = tail.next!!

        p1 = p1?.next
        p2 = p2?.next
    }

    return dummy.next
}

fun addTwoNumbers3(l1: ListNode?, l2: ListNode?): ListNode? {
    fun dfs(a: ListNode?, b: ListNode?, carry: Int): ListNode? {
        if (a == null && b == null && carry == 0) return null

        val x = a?.`val` ?: 0
        val y = b?.`val` ?: 0
        val sum = x + y + carry

        val node = ListNode(sum % 10)
        node.next = dfs(a?.next, b?.next, sum / 10)
        return node
    }

    return dfs(l1, l2, 0)
}
