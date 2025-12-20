package ds


//private data class Node(
//    var value: Int,
//    var next: Node? = null,
//)
//
//
//private class LinkedList {
//    private var head: Node? = null
//    private var tail: Node? = null
//
//    var size: Int = 0
//        private set
//
//    fun isEmpty() = this.size == 0
//
//    fun clear() {
//        head = null
//        tail = null
//        size = 0
//    }
//
//    override fun toString(): String {
//        if (head == null) return "[]"
//
//        val sb = StringBuilder()
//        sb.append("[")
//
//        var curr = head
//        while (curr != null) {
//            sb.append(curr.value)
//            curr = curr.next
//            if (curr != null) sb.append(" -> ")
//        }
//
//        sb.append("]")
//        return sb.toString()
//    }
//
//    fun addFirst(value: Int) {
//        val newNode = Node(value)
//        newNode.next = head
//        head = newNode
//
//        if (tail == null) {
//            tail = head
//        }
//        size++
//    }
//
//    fun addLast(value: Int) {
//        val newNode = Node(value)
//        if (head == null) {
//            head = newNode
//            tail = newNode
//        } else {
//            tail?.next = newNode
//            tail = newNode
//        }
//        size++
//    }
//
//    fun getFirst() = head?.value ?: -1
//
//    fun getLast() = tail?.value ?: -1
//
//    fun get(index: Int): Int {
//        var currentNode = head
//        for (i in 0..index) {
//            if (i == index) return currentNode?.value ?: -1
//            else currentNode = currentNode?.next
//        }
//        return -1
//    }
//
//    fun set(index: Int, value: Int) {
//        var current = head
//        repeat(index) {
//            current = current?.next
//        }
//        current?.value = value
//    }
//
//    fun add(index: Int, value: Int) {
//        if (index < 0 || index > size) {
//            throw IndexOutOfBoundsException("Index: $index, Size: $size")
//        }
//        if (index == 0) {
//            addFirst(value)
//            return
//        }
//        if (index == size) {
//            addLast(value)
//            return
//        }
//
//        var prev = head
//        val newNode = Node(value)
//        repeat(index - 1) {
//            prev = prev?.next
//        }
//        newNode.next = prev?.next
//        prev?.next = newNode
//        size++
//    }
//
//    fun removeFirst() {
//        head = head?.next
//        size--
//    }
//
//    fun removeLast() {
//        var prev = head
//        repeat(size - 2) {
//            prev = prev?.next
//        }
//        prev?.next = null
//        tail = prev
//        size--
//    }
//
//    fun removeAt(index: Int) {
//        if (index < 0 || index >= size) {
//            throw IndexOutOfBoundsException("Index: $index, Size: $size")
//        }
//
//        if (index == 0) return removeFirst()
//        if (index == size - 1) return removeLast()
//
//        var prev = head
//        repeat(index - 1) {
//            prev = prev?.next
//        }
//        val target = prev?.next
//        prev?.next = target?.next
//        size--
//    }
//
//    fun contains(value: Int): Boolean {
//        var current = head
//        repeat(size) {
//            if (current?.value == value) return true
//            current = current?.next
//        }
//        return false
//    }
//
//    fun indexOf(value: Int): Int {
//        var current = head
//        var index = 0
//        while (current != null) {
//            if (current.value == value) return index
//            current = current.next
//            index++
//        }
//        return -1
//    }
//
//    fun remove(value: Int): Boolean {
//        if (head == null) return false
//
//        if (head!!.value == value) {
//            removeFirst()
//            return true
//        }
//
//        var prev = head
//        var curr = head!!.next
//
//        while (curr != null) {
//            if (curr.value == value) {
//                prev!!.next = curr.next
//                if (curr === tail) {
//                    tail = prev
//                }
//                size--
//                return true
//            }
//            prev = curr
//            curr = curr.next
//        }
//        return false
//    }
//
//    operator fun iterator(): Iterator<Int> {
//        var current = head
//        return object : Iterator<Int> {
//            override fun hasNext(): Boolean = current != null
//
//            override fun next(): Int {
//                val node = current ?: throw NoSuchElementException()
//                current = node.next
//                return node.value
//            }
//        }
//    }
//
//    fun reverse() {
//        if (size <= 1) return
//
//        var prev: Node? = null
//        var curr = head
//        tail = head
//
//        while (curr != null) {
//            val next = curr.next
//            curr.next = prev
//            prev = curr
//            curr = next
//        }
//        head = prev
//    }
//
//    fun kthFromEnd(k: Int): Int {
//        if (k <= 0 || k > size) {
//            throw IllegalArgumentException("k must be in 1..$size, got $k")
//        }
//
//        var fast = head
//        repeat(k) {
//            fast = fast!!.next
//        }
//
//        var slow = head
//        while (fast != null) {
//            slow = slow!!.next
//            fast = fast.next
//        }
//
//        return slow!!.value
//    }
//
//    fun hasCycle(): Boolean {
//        var slow = head
//        var fast = head
//
//        while (fast != null && fast.next != null) {
//            slow = slow!!.next
//            fast = fast.next!!.next
//            if (slow === fast) return true
//        }
//
//        return false
//    }
//
//}
//
//private fun main() {
//
//}