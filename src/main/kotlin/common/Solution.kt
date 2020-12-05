package common

abstract class Solution(
    private val problemNumber: Int
) {
    abstract fun problem1(): Any
    abstract fun problem2(): Any

    fun solve() {
        println("Solving $problemNumber")
        val solution1 = problem1()
        println("Solution 1: $solution1")
        val solution2 = problem2()
        println("Solution 2: $solution2")
        println("=========")
    }
}