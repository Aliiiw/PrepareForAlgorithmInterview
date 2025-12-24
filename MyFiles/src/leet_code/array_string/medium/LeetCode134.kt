package leet_code.array_string.medium


fun main() {
    val gas = intArrayOf(1, 2, 3, 4, 5)
    val cost = intArrayOf(3, 4, 5, 1, 2)
    print(canCompleteCircuit2(gas, cost))
}

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    val n = gas.size
    for (start in 0 until n) {
        var tank = 0
        var ok = true

        for (step in 0 until n) {
            val i = (start + step) % n
            tank += gas[i]
            tank -= cost[i]
            if (tank < 0) {
                ok = false
                break
            }
        }

        if (ok) return start
    }
    return -1
}


fun canCompleteCircuit2(gas: IntArray, cost: IntArray): Int {
    var total = 0
    var tank = 0
    var start = 0

    for (i in gas.indices) {
        val diff = gas[i] - cost[i]
        total += diff
        tank += diff

        if (tank < 0) {
            start = i + 1
            tank = 0
        }
    }

    return if (total >= 0) start else -1
}
