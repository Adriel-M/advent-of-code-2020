package common

import java.io.FileNotFoundException
import java.net.URI

fun String.toURI(): URI {
    return this::javaClass.javaClass.classLoader.getResource(this)?.toURI()
        ?: throw FileNotFoundException("Can't find resource $this")
}

