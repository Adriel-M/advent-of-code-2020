package com.adrielm.aoc2020.solutions.day07

private const val NO_OTHER_BAGS = "no other"

class BaggageRule(
    private val ruleLine: String
) {
    private val parentChildren = parse()
    val parentColour = parentChildren.parent
    val children = parentChildren.children

    private fun parse(): ParentChildren {
        val cleaned = ruleLine
            .replace(".", "")
            .replace(" bags", "")
            .replace(" bag", "")
        val parentChildSplit = cleaned.split("contain")
        return ParentChildren(
            parent = parseParent(parentChildSplit.first()),
            children = parseChildren(parentChildSplit.last())
        )
    }

    private fun parseParent(parentPortion: String): String {
        return parentPortion.trim()
    }

    private fun parseChildren(childrenPortion: String): List<ChildAndQuantity> {
        if (childrenPortion.contains(NO_OTHER_BAGS)) return listOf()

        val childrenTrimmed = childrenPortion.trim()
        val childrenSplit = childrenTrimmed.split(",")
        return childrenSplit.map { childPortion ->
            val childSplit = childPortion.trim().split(" ")
            ChildAndQuantity(
                colour = childSplit.drop(1).joinToString(" "),
                quantity = childSplit.first().toInt(),
            )
        }
    }

    private class ParentChildren(
        val parent: String,
        val children: List<ChildAndQuantity>
    )

    class ChildAndQuantity(
        val colour: String,
        val quantity: Int
    )
}
