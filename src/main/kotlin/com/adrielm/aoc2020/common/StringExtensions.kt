package com.adrielm.common

import java.io.FileNotFoundException
import java.net.URI

fun String.toURI(): URI {
    return this::javaClass.javaClass.classLoader.getResource(this)?.toURI()
        ?: throw FileNotFoundException("Can't find resource $this")
}

fun <T> String.toPair(delimiter: String = "-", transformer: (String) -> T): Pair<T, T> {
    val rangeSplit = this.split(delimiter)
    require(rangeSplit.size == 2)
    val first = transformer(rangeSplit[0])
    val second = transformer(rangeSplit[1])
    return Pair(first, second)
}
