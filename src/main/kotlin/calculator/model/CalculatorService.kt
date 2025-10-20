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
        if (delimiter[0].isEmpty() || delimiter[0].length > 1) throw IllegalArgumentException()
        return delimiter[1].split(delimiter[0])
    }

    fun calculate(numbers: List<String>): String {
        var res = "0"
        for (num in numbers) {
            res = sumTwoNumbers(num, res)
        }
        return res
    }

    fun sumTwoNumbers(a: String, b: String): String {
        val digitsA = a.reversed().map { it - '0' }
        val digitsB = b.reversed().map { it - '0' }
        val maxLen = maxOf(digitsA.size, digitsB.size)
        val result = MutableList(maxLen) { 0 }
        var addNum = 0
        for (i in 0 until maxLen) {
            val da = if (i < digitsA.size) digitsA[i] else 0
            val db = if (i < digitsB.size) digitsB[i] else 0
            val sum = da + db + addNum
            result[i] = sum % 10
            addNum = sum / 10
        }
        if (addNum > 0) result.add(addNum)
        return result.reversed().joinToString("")
    }

    fun validateInput(numbers: List<String>) {
        numbers.forEach {
            require(it.all { ch -> ch.isDigit() }) { throw IllegalArgumentException() }
            require(!it.isEmpty()) { throw IllegalArgumentException() }
        }
    }
}