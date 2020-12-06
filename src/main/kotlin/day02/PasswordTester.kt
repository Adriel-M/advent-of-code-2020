package day02

class PasswordTester(
    private val characterPolicy: CharacterPolicy,
    private val password: String
) {
    fun isValidStrategy1(): Boolean {
        val charFrequencies: Map<Char, Int> = password.groupBy { it }
            .mapValues { it.value.size }

        val expectedFrequency = charFrequencies[characterPolicy.char]

        return expectedFrequency != null && expectedFrequency in characterPolicy.lowerUpper.toRange()
    }

    fun isValidStrategy2(): Boolean {
        // 1 based index
        val firstIndex = characterPolicy.lowerUpper.lower - 1
        val secondIndex = characterPolicy.lowerUpper.upper - 1
        return isExpectedCharacterInIndex(firstIndex).xor(isExpectedCharacterInIndex(secondIndex))
    }

    private fun isExpectedCharacterInIndex(indexToCheck: Int): Boolean {
        return password[indexToCheck] == characterPolicy.char
    }
}

