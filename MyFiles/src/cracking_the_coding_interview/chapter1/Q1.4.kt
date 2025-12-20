package cracking_the_coding_interview.chapter1

/*
Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
 The palindrome does not need to be limited to just dictionary words.
 */

fun main() {
    val test = "Tact Coa"
    print(isPalindromePermutation3(test))
}

// v1
fun isPalindromePermutation1(inputText: String): Boolean {
    val normalizedCharacters = inputText
        .lowercase()
        .filter { it != ' ' }
        .toCharArray()

    normalizedCharacters.sort()

    var oddGroupCount = 0
    var index = 0

    while (index < normalizedCharacters.size) {
        val currentCharacter = normalizedCharacters[index]
        var groupSize = 0

        while (index < normalizedCharacters.size && normalizedCharacters[index] == currentCharacter) {
            groupSize++
            index++
        }

        if (groupSize % 2 != 0) {
            oddGroupCount++
            if (oddGroupCount > 1) return false
        }
    }

    return true
}

// v2
fun isPalindromePermutation2(inputText: String): Boolean {
    val normalizedCharacters = inputText
        .lowercase()
        .filter { it != ' ' }

    val frequencyByCharacter = HashMap<Char, Int>()
    for (character in normalizedCharacters) {
        frequencyByCharacter[character] = (frequencyByCharacter[character] ?: 0) + 1
    }

    var oddFrequencyCount = 0
    for (count in frequencyByCharacter.values) {
        if (count % 2 != 0) {
            oddFrequencyCount++
            if (oddFrequencyCount > 1) return false
        }
    }

    return true
}

// v3
fun isPalindromePermutation3(inputText: String): Boolean {
    var oddMask = 0

    for (character in inputText.lowercase()) {
        if (character == ' ') continue
        if (character !in 'a'..'z') continue

        val bitIndex = character - 'a'
        oddMask = oddMask xor (1 shl bitIndex)
    }

    return oddMask == 0 || (oddMask and (oddMask - 1)) == 0
}


