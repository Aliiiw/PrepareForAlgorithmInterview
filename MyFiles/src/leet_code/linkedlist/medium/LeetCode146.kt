package leet_code.linkedlist.medium

import leet_code.linkedlist.easy.ListNode


/**
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists.
Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity
from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
 */


/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

class LRUCache(private val capacity: Int) {
    private class Node(var key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    private val map = HashMap<Int, Node>(capacity * 2)

    private val head = Node(0, 0)
    private val tail = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    private fun addToFront(node: Node) {
        val first = head.next
        node.prev = head
        node.next = first
        head.next = node
        first?.prev = node
    }

    private fun removeNode(node: Node) {
        val p = node.prev
        val n = node.next
        p?.next = n
        n?.prev = p
        node.prev = null
        node.next = null
    }

    private fun moveToFront(node: Node) {
        removeNode(node)
        addToFront(node)
    }

    private fun removeLeastRecentlyUsed(): Node? {
        val lru = tail.prev
        if (lru == null || lru === head) return null
        removeNode(lru)
        return lru
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToFront(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val existing = map[key]
        if (existing != null) {
            existing.value = value
            moveToFront(existing)
            return
        }

        val node = Node(key, value)
        map[key] = node
        addToFront(node)

        if (map.size > capacity) {
            val removed = removeLeastRecentlyUsed()
            if (removed != null) {
                map.remove(removed.key)
            }
        }
    }
}



