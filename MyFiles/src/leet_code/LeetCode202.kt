package leet_code


fun main() {
    print(isHappyFloyed(19))
}


fun nextNumber(num: Int): Int {
    var value = num
    var sumOfSquares = 0

    while (value > 0) {
        val digit = value % 10
        sumOfSquares += digit * digit
        value /= 10
    }

    return sumOfSquares
}

fun isHappy(n: Int): Boolean {
    var x = n
    val seen = HashSet<Int>()

    while (x != 1 && seen.add(x)) {
        x = nextNumber(x)
    }

    return x == 1
}


fun isHappyFloyed(n: Int): Boolean {
    var slow = n
    var fast = n

    do {
        slow = nextNumber(slow)
        fast = nextNumber(nextNumber(fast))
    } while (slow != fast)

    return slow == 1
}


