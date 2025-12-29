package hacker_rank.array

import java.util.*

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    var swaps = 0
    var i = 0

    while (i < arr.size) {
        val correctIndex = i + 1
        if (arr[i] == correctIndex) {
            i++
        } else {
            val j = arr[i] - 1
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            swaps++
        }
    }

    return swaps
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}
