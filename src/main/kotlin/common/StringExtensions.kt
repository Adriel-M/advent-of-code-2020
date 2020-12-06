package common

import java.io.FileNotFoundException
import java.net.URI

fun String.toURI(): URI {
    return this::javaClass.javaClass.classLoader.getResource(this)?.toURI()
        ?: throw FileNotFoundException("Can't find resource $this")
}

fun String.toPair(delimiter: String = "-"): Pair<Int, Int> {
    val rangeSplit = this.split(delimiter)
    require(rangeSplit.size == 2)
    val lower = rangeSplit[0].toInt()
    val upper = rangeSplit[1].toInt()
    return Pair(lower, upper)
}
