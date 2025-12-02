package leet_code

fun numRescueBoats(people: IntArray, limit: Int): Int {
    var boats = 0
    var start = 0
    var end = people.size - 1

    people.sort()

    while (end >= start) {
        if (people[end] + people[start] <= limit) {
            start++
            end--
            boats++
        } else {
            boats++
            end--
        }
    }
    return boats
}