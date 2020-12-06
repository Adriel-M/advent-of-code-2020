package common

abstract class Solution<I, O>(
    private val problemNumber: Int
) {
    abstract fun solveProblem1(input: I): O
    abstract fun solveProblem2(input: I): O
}