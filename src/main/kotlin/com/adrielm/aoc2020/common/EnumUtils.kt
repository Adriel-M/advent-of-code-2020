package com.adrielm.aoc2020.common

inline fun <reified T : Enum<T>> safeEnumValueOf(type: String): T? {
    return try {
        java.lang.Enum.valueOf(T::class.java, type)
    } catch (e: IllegalArgumentException) {
        null
    }
}
