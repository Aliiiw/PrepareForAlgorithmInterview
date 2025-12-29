package hacker_rank.dictionary_and_hashmap

// Complete the countTriplets function below.
fun countTriplets(arr: Array<Long>, r: Long): Long {
    val potential2 = HashMap<Long, Long>()
    val potential3 = HashMap<Long, Long>()
    var ans = 0L

    for (x in arr) {
        ans += potential3[x] ?: 0L

        val p2 = potential2[x] ?: 0L
        if (p2 != 0L) {
            val key3 = x * r
            potential3[key3] = (potential3[key3] ?: 0L) + p2
        }

        val key2 = x * r
        potential2[key2] = (potential2[key2] ?: 0L) + 1L
    }

    return ans
}


fun main(args: Array<String>) {
    val nr = readLine()!!.trimEnd().split(" ")

    val n = nr[0].toInt()

    val r = nr[1].toLong()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toLong() }.toTypedArray()

    val ans = countTriplets(arr, r)

    println(ans)
}
