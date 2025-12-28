package leet_code.trie.medium


/**
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
or vertically neighboring. The same letter cell may not be used more than once in a word.
 */

fun main() {
    print(
        findWords(
            arrayOf(
                charArrayOf('o', 'a', 'a', 'n'),
                charArrayOf('e', 't', 'a', 'e'),
                charArrayOf('i', 'h', 'k', 'r'),
                charArrayOf('i', 'f', 'l', 'v'),
            ),
            arrayOf("oath", "pea", "eat", "rain")
        )
    )
}

fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    class Node {
        val next = arrayOfNulls<Node>(26)
        var word: String? = null
    }

    fun insert(root: Node, w: String) {
        var node = root
        for (ch in w) {
            val idx = ch - 'a'
            var child = node.next[idx]
            if (child == null) {
                child = Node()
                node.next[idx] = child
            }
            node = child
        }
        node.word = w
    }

    val root = Node()
    for (w in words) insert(root, w)

    val rowCount = board.size
    val colCount = board[0].size
    val result = ArrayList<String>()

    fun dfs(row: Int, col: Int, node: Node) {
        val ch = board[row][col]
        if (ch == '\u0000') return

        val child = node.next[ch - 'a'] ?: return

        val found = child.word
        if (found != null) {
            result.add(found)
            child.word = null
        }

        board[row][col] = '\u0000'

        if (row > 0) dfs(row - 1, col, child)
        if (row + 1 < rowCount) dfs(row + 1, col, child)
        if (col > 0) dfs(row, col - 1, child)
        if (col + 1 < colCount) dfs(row, col + 1, child)

        board[row][col] = ch
    }

    for (r in 0 until rowCount) {
        for (c in 0 until colCount) {
            dfs(r, c, root)
        }
    }

    return result
}


