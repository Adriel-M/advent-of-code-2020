package common

object Algorithms {
    fun <T> binarySearch(lower: Int, upper: Int, instructions: List<T>, upperDecision: (T) -> Boolean): Int {
        var currentLower = lower
        var currentUpper = upper

        for (instruction in instructions) {
            val takeUpper = upperDecision(instruction)
            val midPoint = (currentUpper + currentLower) / 2
            if (takeUpper) {
                currentLower = midPoint + 1
            } else {
                currentUpper = midPoint
            }
        }
        return currentLower
    }
}
