package leet_code.trie.medium

/**
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently
store and retrieve keys in a dataset of strings. There are various applications of
this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the
trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously
inserted string word that has the prefix prefix, and false otherwise.
 */


class Trie {
    private class Node {
        val next = arrayOfNulls<Node>(26)
        var isEnd = false
    }

    private val root = Node()

    fun insert(word: String) {
        var node = root
        for (ch in word) {
            val idx = ch - 'a'
            var child = node.next[idx]
            if (child == null) {
                child = Node()
                node.next[idx] = child
            }
            node = child
        }
        node.isEnd = true
    }

    fun search(word: String): Boolean {
        var node: Node? = root
        for (ch in word) {
            val idx = ch - 'a'
            node = node?.next?.get(idx)
            if (node == null) return false
        }
        return node?.isEnd ?: false
    }

    fun startsWith(prefix: String): Boolean {
        var node: Node? = root
        for (ch in prefix) {
            val idx = ch - 'a'
            node = node?.next?.get(idx)
            if (node == null) return false
        }
        return true
    }
}
