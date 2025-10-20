package calculator.model

class CalculatorService {

    fun parseInput(input: String): List<String> {
        return if (input.startsWith("//")) {
            val delimiter = input.split("//", "\n", limit = 3).drop(1)
            delimiter[1].split(delimiter[0])
        } else {
            input.split(":", ",")
        }
    }

    fun calculate(numbers: List<String>): Int {
        var res = 0;
        numbers.forEach { res += it.toInt() }
        return res
    }
}