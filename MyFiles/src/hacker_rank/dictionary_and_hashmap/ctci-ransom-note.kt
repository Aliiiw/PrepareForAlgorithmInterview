package hacker_rank.dictionary_and_hashmap

/*
 * Complete the 'checkMagazine' function below.
 *
 * The function accepts following parameters:
 *  1. STRING_ARRAY magazine
 *  2. STRING_ARRAY note
 */


fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {
    val map = hashMapOf<String, Int>()

    for (word in magazine) {
        map[word] = (map[word] ?: 0) + 1
    }

    for (word in note) {
        val counter = map[word] ?: 0
        if (counter == 0) {
            println("No")
            return
        }
        map[word] = counter - 1
    }

    println("Yes")
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val m = first_multiple_input[0].toInt()

    val n = first_multiple_input[1].toInt()

    val magazine = readLine()!!.trimEnd().split(" ").toTypedArray()

    val note = readLine()!!.trimEnd().split(" ").toTypedArray()

    checkMagazine(magazine, note)
}
