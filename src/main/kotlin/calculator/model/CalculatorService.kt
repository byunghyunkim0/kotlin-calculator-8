package calculator.model

class CalculatorService {

    fun parseInput(input: String): List<String> {
        return if (input.startsWith("//")) {
            customParseInput(input)
        } else if (input[0].isDigit()) {
            defaultParseInput(input)
        } else throw IllegalArgumentException()
    }

    fun defaultParseInput(input: String): List<String> {
        if (input.isEmpty()) return listOf("0")
        return input.split(":", ",")
    }

    fun customParseInput(input: String): List<String> {
        val delimiter = input.split("//", "\\n", limit = 3).drop(1)
        if (delimiter[1].isEmpty()) return listOf("0")
        return delimiter[1].split(delimiter[0])
    }

    fun calculate(numbers: List<String>): Int {
        var res = 0;
        numbers.forEach { res += it.toInt() }
        return res
    }

    fun validateInput(numbers: List<String>) {
        numbers.forEach {
            if (!it[0].isDigit()) throw IllegalArgumentException("문자열은 양수만 입력가능합니다.")
        }
    }
}