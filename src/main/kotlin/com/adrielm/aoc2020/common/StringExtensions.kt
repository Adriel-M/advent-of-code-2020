package com.adrielm.aoc2020.common

import java.io.FileNotFoundException
import java.net.URI

fun String.toURI(): URI {
    return this::javaClass.javaClass.classLoader.getResource(this)?.toURI()
        ?: throw FileNotFoundException("Can't find resource $this")
}
fun <F, S> String.toPair(
    delimiter: String = "-",
    firstTransformer: (String) -> F,
    secondTransformer: (String) -> S
): Pair<F, S> {
    val rangeSplit = split(delimiter)
    require(rangeSplit.size == 2)
    val first = firstTransformer(rangeSplit.first())
    val second = secondTransformer(rangeSplit.last())
    return Pair(first, second)
}

fun <T> String.toPair(delimiter: String = "-", transformer: (String) -> T): Pair<T, T> {
    return toPair(
        delimiter = delimiter,
        firstTransformer = transformer,
        secondTransformer = transformer
    )
}

fun String.split() = split(" ")
