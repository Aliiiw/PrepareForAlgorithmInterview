package leet_code.backtracking.medium


/**
Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.
 */


fun main() {
    print(
        permute(intArrayOf(1, 4, 6, 8))
    )
}


fun permute(nums: IntArray): List<List<Int>> {
    val n = nums.size
    val res = ArrayList<List<Int>>()
    val path = ArrayList<Int>(n)
    val used = BooleanArray(n)

    fun dfs() {
        if (path.size == n) {
            res.add(ArrayList(path))
            return
        }

        for (i in 0 until n) {
            if (used[i]) continue
            used[i] = true
            path.add(nums[i])
            dfs()
            path.removeAt(path.size - 1)
            used[i] = false
        }
    }

    dfs()
    return res
}


