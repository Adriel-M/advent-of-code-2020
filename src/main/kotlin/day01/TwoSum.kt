package day01

class TwoSum {
    fun find(input: List<Int>, target: Int, startingIndex: Int = 0): Pair<Int, Int>? {
        val visited = mutableSetOf<Int>()
        for (i in startingIndex until input.size) {
            val currentNumber = input[i]
            val numberToFind = target - currentNumber
            if (numberToFind in visited) {
                return Pair(numberToFind, currentNumber)
            }
            visited.add(currentNumber)
        }
        return null
    }
}