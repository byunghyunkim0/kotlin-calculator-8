package calculator.controller

import calculator.model.CalculatorService
import calculator.view.CalculatorView

class CalculatorController {
    val calculatorView = CalculatorView()
    val calculatorService = CalculatorService()

    fun run() {
        val input = calculatorView.getInput()
        val numbers = calculatorService.parseInput(input)
        val result = calculatorService.calculate(numbers)
        calculatorView.printResult(result)
    }
}