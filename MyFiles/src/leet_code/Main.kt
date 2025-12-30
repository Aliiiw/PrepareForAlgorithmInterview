import leet_code.binarytree_general.easy.TreeNode
import leet_code.linkedlist.easy.ListNode
import kotlin.math.abs
import kotlin.math.max

fun main() {
    println(singleNumber(intArrayOf(2, 2, 5, 5, 1, 1, 3, 6, 3)))
}

//region importants

// 518
fun change(amount: Int, coins: IntArray): Int {
    /**
     * 1 1 1 1 1
     * 2 2 1
     * 5
     * 2 1 1 1
     */

    val dp = IntArray(amount + 1)

    dp[0] = 1

    for (coin in coins) {
        for (x in coin..amount) {
            dp[x] += dp[x - coin]
        }
    }

    return dp[amount]
}

// 322
fun coinChange(coins: IntArray, amount: Int): Int {
    if (amount == 0) return 0
    val dp = IntArray(amount + 1) { amount + 1 }

    dp[0] = 0

    (1..amount).forEach { index ->
        for (coin in coins) {
            if (coin <= index) {
                dp[index] = minOf(dp[index], dp[index - coin] + 1)
            }
        }
    }

    return if (dp[amount] > amount) -1 else dp[amount]
}

// 91
fun numDecodings(s: String): Int {
    if (s.isEmpty() || s[0] == '0') return 0

    val n = s.length

    var dpNext = 1
    var dpNextNext = dpNext

    dpNext = if (s[n - 1] == '0') 0 else 1

    for (i in n - 2 downTo 0) {
        var cur = 0
        if (s[i] != '0') {
            cur += dpNext

            val two = (s[i] - '0') * 10 + (s[i + 1] - '0')
            if (two in 10..26) {
                cur += dpNextNext
            }
        }
        dpNextNext = dpNext
        dpNext = cur
    }
    return dpNext
}

// 198
fun rob(nums: IntArray): Int {
    var prev1 = 0
    var prev2 = 0

    for (money in nums) {
        val current = maxOf(prev1, prev2 + money)
        prev2 = prev1
        prev1 = current
    }
    return prev1
}

// 213
fun robII(nums: IntArray): Int {
    val n = nums.size
    if (n == 1) return nums[0]

    fun robLinear(start: Int, end: Int): Int {
        var prev2 = 0
        var prev1 = 0
        for (i in start..end) {
            val cur = maxOf(prev1, prev2 + nums[i])
            prev2 = prev1
            prev1 = cur
        }
        return prev1
    }

    val case1 = robLinear(0, n - 2)
    val case2 = robLinear(1, n - 1)
    return maxOf(case1, case2)
}

// 300
fun lengthOfLIS(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val dp = IntArray(nums.size) { 1 }
    var ans = 1

    for (i in nums.indices) {
        for (j in 0 until i) {
            if (nums[j] < nums[i]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
        ans = maxOf(ans, dp[i])
    }
    return ans
}

// 560
fun subarraySum(nums: IntArray, k: Int): Int {
    val map = HashMap<Int, Int>()
    map[0] = 1

    var sum = 0
    var count = 0

    for (num in nums) {
        sum += num
        count += map[sum - k] ?: 0
        map[sum] = (map[sum] ?: 0) + 1
    }
    return count
}

// 3
fun lengthOfLongestSubstring(s: String): Int {
    val set = hashSetOf<Char>()
    var left = 0
    var ans = 0

    for (right in s.indices) {
        while (s[right] in set) {
            set.remove(s[left])
            left++
        }
        set.add(s[right])
        ans = maxOf(ans, right - left + 1)
    }

    return ans
}

// 200
fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    val rows = grid.size
    val cols = grid[0].size
    var count = 0

    fun dfs(r: Int, c: Int) {
        if (r !in 0 until rows || c !in 0 until cols) return
        if (grid[r][c] != '1') return

        grid[r][c] = '0'

        dfs(r + 1, c)
        dfs(r - 1, c)
        dfs(r, c + 1)
        dfs(r, c - 1)
    }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == '1') {
                count++
                dfs(r, c)
            }
        }
    }
    return count
}

// 207
fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val graph = Array(numCourses) { mutableListOf<Int>() }
    val indegree = IntArray(numCourses)

    for (p in prerequisites) {
        val a = p[0]
        val b = p[1]
        graph[b].add(a)
        indegree[a]++
    }

    val q: ArrayDeque<Int> = ArrayDeque()
    for (i in 0 until numCourses) {
        if (indegree[i] == 0) q.addLast(i)
    }

    var taken = 0
    while (q.isNotEmpty()) {
        val course = q.removeFirst()
        taken++

        for (next in graph[course]) {
            indegree[next]--
            if (indegree[next] == 0) q.addLast(next)
        }
    }

    return taken == numCourses
}

// 236
fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || root === p || root === q) return root
    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)
    if (left != null && right != null) return root
    return left ?: right
}

// 543
fun diameterOfBinaryTree(root: TreeNode?): Int {
    var diameter = 0

    fun height(node: TreeNode?): Int {
        if (node == null) return 0

        val left = height(node.left)
        val right = height(node.right)
        diameter = maxOf(diameter, left + right)

        return maxOf(left, right) + 1
    }

    height(root)
    return diameter
}

// 49
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>>()

    for (s in strs) {
        val key = s.toCharArray().sorted().joinToString("")
        val list = map.getOrPut(key) { mutableListOf() }
        list.add(s)
    }

    return map.values.toList()
}

fun groupAnagrams2(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>>()

    for (s in strs) {
        val arr = s.toCharArray()
        arr.sort()
        val key = String(arr)

        map.getOrPut(key) { mutableListOf() }.add(s)
    }

    return map.values.toList()
}

// 647
fun countSubstrings(s: String): Int {
    val n = s.length
    var count = 0

    fun expand(l0: Int, r0: Int) {
        var l = l0
        var r = r0
        while (l >= 0 && r < n && s[l] == s[r]) {
            count++
            l--
            r++
        }
    }

    for (i in 0 until n) {
        expand(i, i)
        expand(i, i + 1)
    }

    return count
}

//endregion

// region easy
// 416
fun canPartition(nums: IntArray): Boolean {
    val sum = nums.sum()
    if (sum % 2 != 0) return false

    val target = sum / 2
    val dp = BooleanArray(target + 1)
    dp[0] = true

    for (x in nums) {
        for (s in target downTo x) {
            dp[s] = dp[s] || dp[s - x]
        }
        if (dp[target]) return true
    }

    return dp[target]
}

// 494
fun findTargetSumWays(nums: IntArray, target: Int): Int {
    val total = nums.sum()
    if (abs(target) > total) return 0

    val all = total + target
    if (all % 2 != 0) return 0

    val size = all / 2
    val dp = IntArray(size + 1)
    dp[0] = 1

    for (x in nums) {
        for (s in size downTo x) {
            dp[s] += dp[s - x]
        }
    }

    return dp[size]
}

// 377
fun combinationSum4(nums: IntArray, target: Int): Int {
    val dp = IntArray(target + 1)
    dp[0] = 1

    for (s in 1..target) {
        var ways = 0
        for (x in nums) {
            if (s - x >= 0) ways += dp[s - x]
        }
        dp[s] = ways
    }
    return dp[target]
}

// 53
fun maxSubArray(nums: IntArray): Int {
    var cur = nums[0]
    var best = nums[0]

    for (i in 1 until nums.size) {
        val x = nums[i]
        cur = maxOf(x, cur + x)
        best = maxOf(best, cur)
    }

    return best
}

// 238
fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val answer = IntArray(n)

    var prefix = 1
    for (i in 0 until n) {
        answer[i] = prefix
        prefix *= nums[i]
    }

    var suffix = 1
    for (i in n - 1 downTo 0) {
        answer[i] *= suffix
        suffix *= nums[i]
    }

    return answer
}

// 424
fun characterReplacement(s: String, k: Int): Int {
    val freq = IntArray(26)
    var left = 0
    var maxFreq = 0
    var best = 0

    for (right in s.indices) {
        val idxR = s[right] - 'A'
        freq[idxR]++
        maxFreq = maxOf(maxFreq, freq[idxR])

        while ((right - left + 1) - maxFreq > k) {
            val idxL = s[left] - 'A'
            freq[idxL]--
            left++
        }

        best = maxOf(best, right - left + 1)
    }

    return best
}

// 994
fun orangesRotting(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size

    val q = ArrayDeque<IntArray>()
    var fresh = 0

    for (r in 0 until m) {
        for (c in 0 until n) {
            when (grid[r][c]) {
                2 -> q.addLast(intArrayOf(r, c))
                1 -> fresh++
            }
        }
    }

    if (fresh == 0) return 0

    val dirs = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )

    var minutes = 0

    while (q.isNotEmpty()) {
        val size = q.size
        var rottedThisMinute = false

        repeat(size) {
            val (r, c) = q.removeFirst()
            for (d in dirs) {
                val nr = r + d[0]
                val nc = c + d[1]
                if (nr in 0 until m && nc in 0 until n && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2
                    fresh--
                    q.addLast(intArrayOf(nr, nc))
                    rottedThisMinute = true
                }
            }
        }

        if (rottedThisMinute) minutes++
    }

    return if (fresh == 0) minutes else -1
}

// 102
fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val res = ArrayList<List<Int>>()
    val q = ArrayDeque<TreeNode>()
    q.addLast(root)

    while (q.isNotEmpty()) {
        val size = q.size
        val level = ArrayList<Int>(size)

        repeat(size) {
            val node = q.removeFirst()
            level.add(node.value)
            node.left?.let { q.addLast(it) }
            node.right?.let { q.addLast(it) }
        }

        res.add(level)
    }

    return res
}

// 104
fun maxDepth(root: TreeNode?): Int {

    if (root == null) return 0

    val left = maxDepth(root.left)
    val right = maxDepth(root.right)

    return max(left, right) + 1
}

// 226
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    val left = invertTree(root.left)
    val right = invertTree(root.right)

    root.left = right
    root.right = left

    return root
}

// 125
fun isPalindrome2(s: String): Boolean {
    val trim = s.filter { it.isLetterOrDigit() }.lowercase()
    return trim.lowercase() == trim.lowercase().reversed()
}

fun isPalindrome(s: String): Boolean {
    var l = 0
    var r = s.length - 1

    while (l < r) {
        while (l < r && !s[l].isLetterOrDigit()) l++
        while (l < r && !s[r].isLetterOrDigit()) r--

        if (s[l].lowercaseChar() != s[r].lowercaseChar()) return false
        l++
        r--
    }
    return true
}

// 242
fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val count = IntArray(26)

    for (c in s) count[c - 'a']++
    for (c in t) {
        val i = c - 'a'
        count[i]--
        if (count[i] < 0) return false
    }

    return true
}

// 70
fun climbStairs(n: Int): Int {
    if (n <= 2) return n

    val dp = IntArray(n + 1)
    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[n]
}

fun findErrorNums(nums: IntArray): IntArray {
    val n = nums.size
    val seen = BooleanArray(n + 1)
    var dup = -1

    for (x in nums) {
        if (seen[x]) dup = x
        else seen[x] = true
    }

    var missing = -1
    for (i in 1..n) {
        if (!seen[i]) {
            missing = i
            break
        }
    }

    return intArrayOf(dup, missing)
}

fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val result = IntArray(nums.size)

    for (i in nums.indices) {
        var counter = 0
        for (j in nums.indices) {
            if (nums[i] > nums[j]) counter++
        }
        result[i] = counter
    }

    return result
}

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val n = nums.size

    for (i in 0 until n) {
        val idx = abs(nums[i]) - 1
        if (nums[idx] > 0) nums[idx] = -nums[idx]
    }

    val result = ArrayList<Int>()
    for (i in 0 until n) {
        if (nums[i] > 0) result.add(i + 1)
    }
    return result
}

// 94
fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun dfs(node: TreeNode?) {
        if (node == null) return
        dfs(node.left)
        result.add(node.value)
        dfs(node.right)
    }

    dfs(root)
    return result
}

// 110
fun isBalanced(root: TreeNode?): Boolean {
    fun checkHeight(node: TreeNode?): Int {
        if (node == null) return 0

        val left = checkHeight(node.left)
        if (left == -1) return -1

        val right = checkHeight(node.right)
        if (right == -1) return -1

        if (abs(left - right) > 1) return -1

        return maxOf(left, right) + 1
    }

    return checkHeight(root) != -1
}

// 111
fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0

    val q = ArrayDeque<Pair<TreeNode, Int>>()
    q.addLast(Pair(root, 1))

    while (q.isNotEmpty()) {
        val (node, depth) = q.removeFirst()

        if (node.left == null && node.right == null) return depth

        node.left?.let { q.addLast(Pair(it, depth + 1)) }
        node.right?.let { q.addLast(Pair(it, depth + 1)) }
    }

    return 0
}

// 118
fun generate(numRows: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    for (i in 0 until numRows) {
        val row = MutableList(i + 1) { 1 }
        for (j in 1 until i) {
            row[j] = result[i - 1][j - 1] + result[i - 1][j]
        }
        result.add(row)
    }

    return result
}

// 119
fun getRow(rowIndex: Int): List<Int> {
    val row = IntArray(rowIndex + 1)
    row[0] = 1

    for (i in 1..rowIndex) {
        for (j in i downTo 1) {
            row[j] += row[j - 1]
        }
    }

    return row.toList()
}

// 114
fun preorderTraversal(root: TreeNode?): List<Int> {
    val result = arrayListOf<Int>()

    fun dfs(node: TreeNode?) {
        if (node == null) return
        result.add(node.value)
        dfs(node.left)
        dfs(node.right)
    }
    dfs(root)
    return result
}

// 145
fun postorderTraversal(root: TreeNode?): List<Int> {
    val result = arrayListOf<Int>()

    fun dfs(node: TreeNode?) {
        if (node == null) return
        dfs(node.left)
        dfs(node.right)
        result.add(node.value)
    }

    dfs(root)
    return result
}

// 168
fun convertToTitle(columnNumber: Int): String {
    var n = columnNumber
    val sb = StringBuilder()

    while (n > 0) {
        n--
        val ch = ('A'.code + (n % 26)).toChar()
        sb.append(ch)
        n /= 26
    }

    return sb.reverse().toString()
}

// 171
fun titleToNumber(columnTitle: String): Int {
    var ans = 0
    for (ch in columnTitle) {
        val v = (ch - 'A') + 1
        ans = ans * 26 + v
    }
    return ans
}

//endregion

// region mediums

// 7
fun reverse(x: Int): Int {
    var n = x
    var rev = 0

    while (n != 0) {
        val digit = n % 10
        n /= 10

        if (rev > Int.MAX_VALUE / 10 ||
            (rev == Int.MAX_VALUE / 10 && digit > 7)
        ) {
            return 0
        }
        if (rev < Int.MIN_VALUE / 10 ||
            (rev == Int.MIN_VALUE / 10 && digit < -8)
        ) {
            return 0
        }

        rev = rev * 10 + digit
    }

    return rev
}

// 8
fun myAtoi(s: String): Int {
    val n = s.length
    var i = 0

    while (i < n && s[i] == ' ') i++

    if (i == n) return 0

    var sign = 1
    if (s[i] == '+' || s[i] == '-') {
        if (s[i] == '-') sign = -1
        i++
    }

    var res = 0
    while (i < n && s[i].isDigit()) {
        val digit = s[i] - '0'

        if (res > Int.MAX_VALUE / 10 ||
            (res == Int.MAX_VALUE / 10 && digit > 7)
        ) {
            return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
        }

        res = res * 10 + digit
        i++
    }

    return res * sign
}

//16
fun threeSumClosest(nums: IntArray, target: Int): Int {
    nums.sort()
    var best = nums[0] + nums[1] + nums[2]

    for (i in 0 until nums.size - 2) {
        var l = i + 1
        var r = nums.size - 1

        while (l < r) {
            val sum = nums[i] + nums[l] + nums[r]

            if (kotlin.math.abs(sum - target) < kotlin.math.abs(best - target)) {
                best = sum
            }

            when {
                sum == target -> return sum
                sum < target -> l++
                else -> r--
            }
        }
    }
    return best
}

// 18
fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    nums.sort()
    val n = nums.size
    val res = mutableListOf<List<Int>>()
    val tgt = target.toLong()

    for (i in 0 until n - 3) {
        if (i > 0 && nums[i] == nums[i - 1]) continue

        for (j in i + 1 until n - 2) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue

            var l = j + 1
            var r = n - 1

            while (l < r) {
                val sum = nums[i].toLong() + nums[j].toLong() + nums[l].toLong() + nums[r].toLong()

                when {
                    sum == tgt -> {
                        res.add(listOf(nums[i], nums[j], nums[l], nums[r]))

                        val leftVal = nums[l]
                        val rightVal = nums[r]
                        while (l < r && nums[l] == leftVal) l++
                        while (l < r && nums[r] == rightVal) r--
                    }

                    sum < tgt -> l++
                    else -> r--
                }
            }
        }
    }

    return res
}

// 24
fun swapPairs(head: ListNode?): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head

    var prev: ListNode? = dummy

    while (prev?.next != null && prev.next?.next != null) {
        val first = prev.next
        val second = first?.next

        first?.next = second?.next
        second?.next = first
        prev.next = second

        prev = first
    }

    return dummy.next
}

// 31
fun nextPermutation(nums: IntArray) {
    val n = nums.size

    var i = n - 2
    while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--
    }

    if (i < 0) {
        nums.reverse()
        return
    }

    var j = n - 1
    while (nums[j] <= nums[i]) {
        j--
    }

    val tmp = nums[i]
    nums[i] = nums[j]
    nums[j] = tmp

    var l = i + 1
    var r = n - 1
    while (l < r) {
        val t = nums[l]
        nums[l] = nums[r]
        nums[r] = t
        l++
        r--
    }
}

// 38
fun countAndSay(n: Int): String {
    var cur = "1"
    if (n == 1) return cur

    for (step in 2..n) {
        val sb = StringBuilder()
        var i = 0

        while (i < cur.length) {
            val ch = cur[i]
            var count = 1

            while (i + count < cur.length && cur[i + count] == ch) {
                count++
            }

            sb.append(count)
            sb.append(ch)

            i += count
        }

        cur = sb.toString()
    }

    return cur
}

// 40
fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    val res = mutableListOf<List<Int>>()
    val path = ArrayList<Int>()

    fun dfs(start: Int, remaining: Int) {
        if (remaining == 0) {
            res.add(ArrayList(path))
            return
        }

        for (i in start until candidates.size) {
            if (i > start && candidates[i] == candidates[i - 1]) continue

            val x = candidates[i]
            if (x > remaining) break

            path.add(x)
            dfs(i + 1, remaining - x)
            path.removeAt(path.size - 1)
        }
    }

    dfs(0, target)
    return res
}

// 43
fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") return "0"

    val m = num1.length
    val n = num2.length
    val res = IntArray(m + n)

    for (i in m - 1 downTo 0) {
        val a = num1[i] - '0'
        for (j in n - 1 downTo 0) {
            val b = num2[j] - '0'
            val sum = a * b + res[i + j + 1]
            res[i + j + 1] = sum % 10
            res[i + j] += sum / 10
        }
    }

    var k = 0
    while (k < res.size && res[k] == 0) k++

    val sb = StringBuilder()
    while (k < res.size) {
        sb.append(res[k])
        k++
    }
    return sb.toString()
}

// 47
fun permuteUnique(nums: IntArray): List<List<Int>> {
    nums.sort()
    val res = ArrayList<List<Int>>()
    val used = BooleanArray(nums.size)
    val path = IntArray(nums.size)
    var depth = 0

    fun dfs() {
        if (depth == nums.size) {
            res.add(path.toList())
            return
        }

        for (i in nums.indices) {
            if (used[i]) continue
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue

            used[i] = true
            path[depth] = nums[i]
            depth++
            dfs()
            depth--
            used[i] = false
        }
    }

    dfs()
    return res
}

// 59
fun generateMatrix(n: Int): Array<IntArray> {
    val res = Array(n) { IntArray(n) }
    var top = 0
    var bottom = n - 1
    var left = 0
    var right = n - 1
    var cur = 1
    val end = n * n

    while (cur <= end) {
        for (j in left..right) res[top][j] = cur++
        top++

        for (i in top..bottom) res[i][right] = cur++
        right--

        if (top <= bottom) {
            for (j in right downTo left) res[bottom][j] = cur++
            bottom--
        }

        if (left <= right) {
            for (i in bottom downTo top) res[i][left] = cur++
            left++
        }
    }

    return res
}

// 62
fun uniquePaths(m: Int, n: Int): Int {
    val dp = Array(m) { IntArray(n) }

    for (i in 0 until m) dp[i][0] = 1
    for (j in 0 until n) dp[0][j] = 1

    for (i in 1 until m) {
        for (j in 1 until n) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }

    return dp[m - 1][n - 1]
}

fun uniquePaths1D(m: Int, n: Int): Int {
    val dp = IntArray(n) { 1 }
    for (i in 1 until m) {
        for (j in 1 until n) {
            dp[j] += dp[j - 1]
        }
    }
    return dp[n - 1]
}

// 75
fun sortColors(nums: IntArray) {
    var counter0 = 0
    var counter1 = 0
    var counter2 = 0

    for (number in nums) {
        when (number) {
            0 -> counter0++
            1 -> counter1++
            else -> counter2++
        }
    }

    var i = 0
    repeat(counter0) { nums[i++] = 0 }
    repeat(counter1) { nums[i++] = 1 }
    repeat(counter2) { nums[i++] = 2 }
}

// 78
fun subsets(nums: IntArray): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val current = ArrayList<Int>()

    fun dfs(i: Int) {
        if (i == nums.size) {
            result.add(ArrayList(current))
            return
        }

        dfs(i + 1)

        current.add(nums[i])
        dfs(i + 1)

        current.removeAt(current.size - 1)
    }

    dfs(0)
    return result
}

fun subsetsIterative(nums: IntArray): List<List<Int>> {
    val res = ArrayList<List<Int>>()
    res.add(emptyList())

    for (number in nums) {
        val size = res.size
        for (i in 0 until size) {
            val next = ArrayList(res[i])
            next.add(number)
            res.add(next)
        }
    }

    return res
}

// 81
fun searchSimple(nums: IntArray, target: Int): Boolean {
    return target in nums
}

fun search(nums: IntArray, target: Int): Boolean {
    var l = 0
    var r = nums.size - 1

    while (l <= r) {
        val m = l + (r - l) / 2
        if (nums[m] == target) return true

        if (nums[l] == nums[m] && nums[m] == nums[r]) {
            l++
            r--
            continue
        }

        if (nums[l] <= nums[m]) {
            if (nums[l] <= target && target < nums[m]) r = m - 1
            else l = m + 1
        } else {
            if (nums[m] < target && target <= nums[r]) l = m + 1
            else r = m - 1
        }
    }

    return false
}

// 89
fun grayCode(n: Int): List<Int> {
    val size = 1 shl n
    val res = ArrayList<Int>(size)
    for (i in 0 until size) {
        res.add(i xor (i shr 1))
    }
    return res
}

// 90
fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    nums.sort()
    val res = ArrayList<List<Int>>()
    val cur = ArrayList<Int>()

    fun dfs(start: Int) {
        res.add(ArrayList(cur))

        for (i in start until nums.size) {
            if (i > start && nums[i] == nums[i - 1]) continue
            cur.add(nums[i])
            dfs(i + 1)
            cur.removeAt(cur.size - 1)
        }
    }

    dfs(0)
    return res
}

fun subsetsWithDupIterative(nums: IntArray): List<List<Int>> {
    nums.sort()
    val res = ArrayList<List<Int>>()
    res.add(emptyList())

    var lastAddedStart = 0

    for (i in nums.indices) {
        val start = if (i > 0 && nums[i] == nums[i - 1]) lastAddedStart else 0
        val sizeBefore = res.size
        lastAddedStart = sizeBefore

        for (j in start until sizeBefore) {
            val next = ArrayList(res[j])
            next.add(nums[i])
            res.add(next)
        }
    }

    return res
}

// 93
fun restoreIpAddresses(s: String): List<String> {
    val n = s.length
    if (n < 4 || n > 12) return emptyList()

    val res = ArrayList<String>()
    val parts = IntArray(4)

    fun dfs(idx: Int, part: Int) {
        if (part == 4) {
            if (idx == n) {
                res.add("${parts[0]}.${parts[1]}.${parts[2]}.${parts[3]}")
            }
            return
        }

        val remainingChars = n - idx
        val remainingParts = 4 - part
        if (remainingChars < remainingParts || remainingChars > remainingParts * 3) return

        var value = 0
        for (len in 1..3) {
            if (idx + len > n) break
            if (len > 1 && s[idx] == '0') break

            value = value * 10 + (s[idx + len - 1] - '0')
            if (value > 255) break

            parts[part] = value
            dfs(idx + len, part + 1)
        }
    }

    dfs(0, 0)
    return res
}

// 95
fun generateTrees(n: Int): List<TreeNode?> {
    if (n == 0) return emptyList()

    val memo = HashMap<Long, List<TreeNode?>>()

    fun key(l: Int, r: Int): Long = (l.toLong() shl 32) or (r.toLong() and 0xffffffffL)

    fun build(l: Int, r: Int): List<TreeNode?> {
        if (l > r) return listOf(null)

        val k = key(l, r)
        memo[k]?.let { return it }

        val res = ArrayList<TreeNode?>()
        for (rootVal in l..r) {
            val leftTrees = build(l, rootVal - 1)
            val rightTrees = build(rootVal + 1, r)

            for (lt in leftTrees) {
                for (rt in rightTrees) {
                    val root = TreeNode(rootVal)
                    root.left = lt
                    root.right = rt
                    res.add(root)
                }
            }
        }

        memo[k] = res
        return res
    }

    return build(1, n)
}

// 131
fun partition(s: String): List<List<String>> {
    val n = s.length
    val pal = Array(n) { BooleanArray(n) }

    for (i in n - 1 downTo 0) {
        for (j in i until n) {
            pal[i][j] = s[i] == s[j] && (j - i < 2 || pal[i + 1][j - 1])
        }
    }

    val res = ArrayList<List<String>>()
    val cur = ArrayList<String>()

    fun dfs(start: Int) {
        if (start == n) {
            res.add(ArrayList(cur))
            return
        }
        for (end in start until n) {
            if (!pal[start][end]) continue
            cur.add(s.substring(start, end + 1))
            dfs(end + 1)
            cur.removeAt(cur.size - 1)
        }
    }

    dfs(0)
    return res
}

// 152
fun maxProduct(nums: IntArray): Int {
    var maxEnd = nums[0]
    var minEnd = nums[0]
    var ans = nums[0]

    for (i in 1 until nums.size) {
        val x = nums[i]
        if (x < 0) {
            val t = maxEnd
            maxEnd = minEnd
            minEnd = t
        }

        maxEnd = maxOf(x, maxEnd * x)
        minEnd = minOf(x, minEnd * x)

        ans = maxOf(ans, maxEnd)
    }

    return ans
}

// 713
fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
    if (k <= 1) return 0

    var prod = 1L
    var l = 0
    var ans = 0

    for (r in nums.indices) {
        prod *= nums[r].toLong()
        while (prod >= k && l <= r) {
            prod /= nums[l].toLong()
            l++
        }
        ans += (r - l + 1)
    }

    return ans
}

// 567
fun checkInclusion(s1: String, s2: String): Boolean {
    val m = s1.length
    val n = s2.length
    if (m > n) return false

    val need = IntArray(26)
    val window = IntArray(26)

    for (ch in s1) need[ch - 'a']++


    for (i in 0 until m) {
        window[s2[i] - 'a']++
    }

    if (sameCounts(need, window)) return true

    for (r in m until n) {
        val addIdx = s2[r] - 'a'
        val removeIdx = s2[r - m] - 'a'
        window[addIdx]++
        window[removeIdx]--

        if (sameCounts(need, window)) return true
    }

    return false
}

private fun sameCounts(a: IntArray, b: IntArray): Boolean {
    for (i in 0 until 26) {
        if (a[i] != b[i]) return false
    }
    return true
}

// 974
fun subarraysDivByK(nums: IntArray, k: Int): Int {
    val count = IntArray(k)
    count[0] = 1

    var sum = 0
    var ans = 0

    for (x in nums) {
        sum += x
        var rem = sum % k
        if (rem < 0) rem += k

        ans += count[rem]
        count[rem]++
    }

    return ans
}

// 525
fun findMaxLength(nums: IntArray): Int {
    val firstIndex = HashMap<Int, Int>()
    firstIndex[0] = -1

    var sum = 0
    var best = 0

    for (i in nums.indices) {
        sum += if (nums[i] == 1) 1 else -1

        val prev = firstIndex[sum]
        if (prev != null) {
            best = maxOf(best, i - prev)
        } else {
            firstIndex[sum] = i
        }
    }

    return best
}

// 733
fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    val m = image.size
    val n = image[0].size
    val old = image[sr][sc]

    if (old == color) return image

    fun dfs(r: Int, c: Int) {
        if (r !in 0 until m || c !in 0 until n) return
        if (image[r][c] != old) return

        image[r][c] = color

        dfs(r + 1, c)
        dfs(r - 1, c)
        dfs(r, c + 1)
        dfs(r, c - 1)
    }

    dfs(sr, sc)
    return image
}

// 338
fun countBits(n: Int): IntArray {
    val ans = IntArray(n + 1)
    for (i in 1..n) {
        ans[i] = ans[i shr 1] + (i and 1)
    }
    return ans
}

// 136
fun singleNumber(nums: IntArray): Int {
    val map = hashMapOf<Int, Int>()
    var result = 0

    for (number in nums) {
        map[number] = (map[number] ?: 0) + 1
    }

    for (item in map) {
        if (item.value == 1) {
            result = item.key
        }
    }

    return result
}

fun singleNumberBest(nums: IntArray): Int {
    var ans = 0
    for (number in nums) {
        ans = ans xor number
    }
    return ans
}

//endregion