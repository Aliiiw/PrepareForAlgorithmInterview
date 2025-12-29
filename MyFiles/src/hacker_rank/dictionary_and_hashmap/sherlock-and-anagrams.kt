package hacker_rank.dictionary_and_hashmap

/*
 * Complete the 'sherlockAndAnagrams' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

fun sherlockAndAnagrams(s: String): Int {
    val n = s.length
    val map = HashMap<String, Int>()

    for (i in 0 until n) {
        for (j in i + 1..n) {
            val sub = s.substring(i, j).toCharArray()
            sub.sort()
            val key = String(sub)
            map[key] = (map[key] ?: 0) + 1
        }
    }

    var ans = 0
    for (c in map.values) {
        ans += c * (c - 1) / 2
    }
    return ans
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!

        val result = sherlockAndAnagrams(s)

        println(result)
    }
}
