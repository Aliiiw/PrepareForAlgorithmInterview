package cracking_the_coding_interview.chapter1

import javax.xml.stream.events.Characters

/*
Is Unique: Implement an algorithm to determine if a string has all unique characters.
 What if you cannot use additional data structures?
 */

fun main() {
    val testString = "ali rh"

    print(isUniqCharacter3(testString))
}

// v1
fun isUniqCharacter(input: String): Boolean {
    return input.length == input.toSet().size
}

// v2
fun isUniqCharacter2(input: String): Boolean {
    val characters = arrayListOf<Char>()
    input.forEach { char ->
        if (characters.contains(char).not()) {
            characters.add(char)
        } else {
            return false
        }
    }
    return true
}

// v3
fun isUniqCharacter3(input: String): Boolean {
    val characters = input.toCharArray()

    characters.sort()
    for (i in 1 until characters.size) {
        if (characters[i] == characters[i - 1]) return false
    }
    return true
}


