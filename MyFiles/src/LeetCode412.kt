
fun fizzBuzz(n: Int): List<String> {
    val items = mutableListOf<String>()
    for (i in 1..n) {
        if (i % 15 == 0)
            items.add("FizzBuzz")
        else if (i % 3 == 0)
            items.add("Fizz")
        else if (i % 5 == 0)
            items.add("Buzz")
        else items.add(i.toString())
    }
    return items
}