package leet_code.trie.medium

/**
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches
word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */

class WordDictionary {
    private class Node {
        val next = arrayOfNulls<Node>(26)
        var isEnd = false
    }

    private val root = Node()

    fun addWord(word: String) {
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
        fun dfs(node: Node?, index: Int): Boolean {
            if (node == null) return false
            if (index == word.length) return node.isEnd

            val ch = word[index]
            if (ch != '.') {
                return dfs(node.next[ch - 'a'], index + 1)
            }

            for (i in 0 until 26) {
                if (dfs(node.next[i], index + 1)) return true
            }
            return false
        }

        return dfs(root, 0)
    }
}

