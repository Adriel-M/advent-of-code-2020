package com.adrielm.aoc2020.solutions.day07

import com.adrielm.aoc2020.common.FileUtils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.koin.test.inject

class Day07Test : BaseTest() {
    private val day07: Day07 by inject()

    override fun `example problem 1`() {
        val example =
            """
            light red bags contain 1 bright white bag, 2 muted yellow bags.
            dark orange bags contain 3 bright white bags, 4 muted yellow bags.
            bright white bags contain 1 shiny gold bag.
            muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
            shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
            dark olive bags contain 3 faded blue bags, 4 dotted black bags.
            vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
            faded blue bags contain no other bags.
            dotted black bags contain no other bags.
            """.trimIndent()
        val baggageRules = example.lines().map { BaggageRule(it) }
        assertThat(day07.solveProblem1(baggageRules)).isEqualTo(4)
    }

    override fun `input problem 1`() {
        val baggageRules = FileUtils.fileToList("day07.txt") { BaggageRule(it) }
        assertThat(day07.solveProblem1(baggageRules)).isEqualTo(139)
    }

    override fun `example problem 2`() {
        val example =
            """
            shiny gold bags contain 2 dark red bags.
            dark red bags contain 2 dark orange bags.
            dark orange bags contain 2 dark yellow bags.
            dark yellow bags contain 2 dark green bags.
            dark green bags contain 2 dark blue bags.
            dark blue bags contain 2 dark violet bags.
            dark violet bags contain no other bags.
            """.trimIndent()
        val baggageRules = example.lines().map { BaggageRule(it) }
        assertThat(day07.solveProblem2(baggageRules)).isEqualTo(126)
    }

    override fun `input problem 2`() {
        val baggageRules = FileUtils.fileToList("day07.txt") { BaggageRule(it) }
        assertThat(day07.solveProblem2(baggageRules)).isEqualTo(58175)
    }
}
