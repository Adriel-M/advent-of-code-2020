package com.adrielm.aoc2020.solutions.day02

class LowerUpper(
    val lower: Int,
    val upper: Int
) {
    fun toRange(): IntRange = lower..upper
}
