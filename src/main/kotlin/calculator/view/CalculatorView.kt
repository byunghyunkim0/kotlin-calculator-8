package calculator.view

import camp.nextstep.edu.missionutils.Console.readLine

class CalculatorView {

    fun getInput(): String {
        print("덧셈할 문자열을 입력해 주세요.")
        return readLine()
    }
}