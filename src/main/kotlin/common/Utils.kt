package common

import org.koin.dsl.module
import java.io.File

object Utils {
    private fun <T> fileToList(file: File, transformer: (String) -> T): List<T> {
        return file.useLines { fileSequence ->
            fileSequence.map { line ->
                transformer(line)
            }
            .toList()
        }
    }

    fun resourceToIntList(resourceName: String): List<Int> {
        val resourcePath = resourceName.toURI()
        return fileToList(File(resourcePath)) { it.toInt() }
    }
}