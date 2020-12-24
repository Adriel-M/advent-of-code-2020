package com.adrielm.aoc2020.common

import java.io.File

object FileUtils {
    private fun <T> fileToList(file: File, transformer: (String) -> T): List<T> {
        return file.useLines { fileSequence ->
            fileSequence.map { line ->
                transformer(line)
            }
                .toList()
        }
    }

    fun <T> fileToList(resourceName: String, transformer: (String) -> T): List<T> {
        val resourcePath = resourceName.toURI()
        return fileToList(File(resourcePath), transformer)
    }

    fun resourceToIntList(resourceName: String): List<Int> {
        return fileToList(resourceName) { it.toInt() }
    }
}
