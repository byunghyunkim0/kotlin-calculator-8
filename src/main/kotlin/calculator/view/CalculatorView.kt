package calculator.view

import camp.nextstep.edu.missionutils.Console.readLine

class CalculatorView {

    fun getInput(): String {
        println("덧셈할 문자열을 입력해 주세요.")
        return readLine()
    }

    fun printResult(result: String) {
        print("결과 : $result")
    }
}