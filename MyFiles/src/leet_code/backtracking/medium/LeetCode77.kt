package leet_code.backtracking.medium


/**
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.
 */


fun main() {
    print(
        combine(4, 2)
    )
}


fun combine(n: Int, k: Int): List<List<Int>> {
    val res = ArrayList<List<Int>>()
    val path = ArrayList<Int>(k)

    fun dfs(start: Int) {
        if (path.size == k) {
            res.add(ArrayList(path))
            return
        }

        for (x in start..n) {
            path.add(x)
            dfs(x + 1)
            path.removeAt(path.size - 1)
        }
    }

    dfs(1)
    return res
}

