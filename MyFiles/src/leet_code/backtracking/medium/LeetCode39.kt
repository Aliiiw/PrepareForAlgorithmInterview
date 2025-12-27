package leet_code.backtracking.medium


/**
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to
target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
 */


fun main() {
    print(
        combinationSum(intArrayOf(1, 4, 6, 8), 4)
    )
}


fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val res = ArrayList<List<Int>>()
    val path = ArrayList<Int>()

    fun dfs(start: Int, remain: Int) {
        if (remain == 0) {
            res.add(ArrayList(path))
            return
        }
        if (remain < 0) return

        for (i in start until candidates.size) {
            path.add(candidates[i])
            dfs(i, remain - candidates[i])
            path.removeAt(path.size - 1)
        }
    }

    dfs(0, target)
    return res
}

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()

    val res = ArrayList<List<Int>>()
    val path = ArrayList<Int>()

    fun dfs(start: Int, remain: Int) {
        if (remain == 0) {
            res.add(ArrayList(path))
            return
        }

        for (i in start until candidates.size) {
            val x = candidates[i]
            if (x > remain) break
            path.add(x)
            dfs(i, remain - x)
            path.removeAt(path.size - 1)
        }
    }

    dfs(0, target)
    return res
}

