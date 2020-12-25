package com.adrielm.aoc2020.solutions.day07

import com.adrielm.aoc2020.common.Algorithms
import com.adrielm.aoc2020.common.Solution
import org.koin.dsl.module

class Day07 : Solution<List<BaggageRule>, Int>(7) {
    override fun solveProblem1(input: List<BaggageRule>): Int {
        // build a graph from child to parent
        val childToParentGraph = mutableMapOf<String, MutableSet<String>>()
        for (rule in input) {
            for (child in rule.children) {
                childToParentGraph.getOrPut(child.colour) { mutableSetOf() }.add(rule.parentColour)
            }
        }
        // start -1 because lambda performs action at every level
        var parentCountThatHoldsGold = -1
        Algorithms.dfsActionEveryLevel(childToParentGraph, "shiny gold") { parentCountThatHoldsGold++ }
        return parentCountThatHoldsGold
    }

    override fun solveProblem2(input: List<BaggageRule>): Int {
        val parentToChildGraph = mutableMapOf<String, Set<BaggageRule.ChildAndQuantity>>()
        for (rule in input) {
            parentToChildGraph[rule.parentColour] = rule.children.toSet()
        }

        return Algorithms.dfsReturn(
            graph = parentToChildGraph,
            start = "shiny gold",
            getChildKeyLambda = { it.colour },
            visitedAlreadyLambda = { 0 },
            endOfLevelLambda = { _, childrenAndReturns ->
                1 + childrenAndReturns.sumBy { childAndReturn ->
                    childAndReturn.first.quantity * childAndReturn.second
                }
            }
        ) - 1 // exclude the starting baggage
    }

    companion object {
        val module = module {
            single { Day07() }
        }
    }
}
