package com.adrielm.aoc2020.common

object Algorithms {
    fun twoSum(input: List<Int>, target: Int, startingIndex: Int = 0): Pair<Int, Int>? {
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

    fun threeSum(input: List<Int>, target: Int): Triple<Int, Int, Int>? {
        for ((i, currentNumber) in input.withIndex()) {
            val targetTwoSum = target - currentNumber
            val twoSumAnswer = twoSum(input, targetTwoSum, i + 1)
            if (twoSumAnswer != null) {
                return Triple(twoSumAnswer.first, twoSumAnswer.second, currentNumber)
            }
        }
        return null
    }

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

    private fun <PT, CT, O> dfs(
        graph: Map<PT, Collection<CT>>,
        start: PT,
        getChildKeyLambda: (CT) -> PT,
        actionAtEachLevel: (PT) -> Unit,
        visitedAlreadyLambda: (PT) -> O,
        endOfLevelLambda: (PT, List<Pair<CT, O>>) -> O
    ): O {
        val visitedAndReturn = mutableSetOf<PT>()

        fun traverse(current: PT): O {
            if (current in visitedAndReturn) return visitedAlreadyLambda(current)

            actionAtEachLevel(current)
            visitedAndReturn.add(current)

            val children = graph[current] ?: listOf()
            val childAndOutput = children.map { Pair(it, traverse(getChildKeyLambda(it))) }

            return endOfLevelLambda(current, childAndOutput)
        }
        return traverse(start)
    }

    fun <T> dfsActionEveryLevel(graph: Map<T, Set<T>>, start: T, actionAtEachLevel: (T) -> Unit) {
        dfs(
            graph = graph,
            start = start,
            actionAtEachLevel = actionAtEachLevel,
            getChildKeyLambda = { it },
            visitedAlreadyLambda = { },
            endOfLevelLambda = { _, _ -> }
        )
    }

    fun <PT, CT, O> dfsReturn(
        graph: Map<PT, Set<CT>>,
        start: PT,
        getChildKeyLambda: (CT) -> PT,
        visitedAlreadyLambda: (PT) -> O,
        endOfLevelLambda: (PT, List<Pair<CT, O>>) -> O
    ): O {
        return dfs(
            graph = graph,
            start = start,
            getChildKeyLambda = getChildKeyLambda,
            actionAtEachLevel = { },
            visitedAlreadyLambda = visitedAlreadyLambda,
            endOfLevelLambda = endOfLevelLambda,
        )
    }
}
