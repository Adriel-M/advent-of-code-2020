package day04

private val hexMatcher = "^#[0-9a-f]{6}$".toRegex()

private val validEyeColours = setOf(
    "amb",
    "blu",
    "brn",
    "gry",
    "grn",
    "hzl",
    "oth"
)

enum class RequiredPassportEntries {
    BYR {
        override fun isValid(value: String): Boolean {
            return value.toInt() in 1920..2002
        }
    },
    IYR {
        override fun isValid(value: String): Boolean {
            return value.toInt() in 2010..2020
        }
    },
    EYR {
        override fun isValid(value: String): Boolean {
            return value.toInt() in 2020..2030
        }
    },
    HGT {
        override fun isValid(value: String): Boolean {
            val valueSplit = value.groupBy { it.isDigit() }

            if (valueSplit.size != 2) return false

            val number = valueSplit[true]!!.joinToString(separator = "").toInt()

            return when (valueSplit[false]!!.joinToString(separator = "")) {
                "cm" -> number in 150..193
                "in" -> number in 59..76
                else -> false
            }
        }
    },
    HCL {
        override fun isValid(value: String): Boolean {
            val yo = value.matches(hexMatcher)
            return yo
        }
    },
    ECL {
        override fun isValid(value: String): Boolean {
            return value in validEyeColours
        }
    },
    PID {
        override fun isValid(value: String): Boolean {
            return value.length == 9 && value.all { it.isDigit() }
        }
    }
    ;
    abstract fun isValid(value: String): Boolean
}
