package calculator.model

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorServiceTest {
    val calculatorService = CalculatorService()

    @Test
    fun `잘못된_입력_구분_기능_테스트`() {
        assertSimpleTest {
            val input = "/\n899854"
            assertThrows<IllegalArgumentException> { calculatorService.parseInput(input) }
        }
    }

    @Test
    fun `기본_문자열_공백_입력_테스트`() {
        assertSimpleTest {
            val input = ""
            val res = listOf("0")
            assertThat(calculatorService.defaultParseInput(input)).isEqualTo(res)
        }
    }

    @Test
    fun `기본_문자열_입력_테스트`() {
        assertSimpleTest {
            val input = "5:10,20:80"
            val res = listOf("5", "10", "20", "80")
            assertThat(calculatorService.defaultParseInput(input)).isEqualTo(res)
        }
    }

    @Test
    fun `커스텀_문자열_공백_입력_테스트`() {
        assertSimpleTest {
            val input = "//;\\n"
            val res = listOf("0")
            assertThat(calculatorService.customParseInput(input)).isEqualTo(res)
        }
    }

    @Test
    fun `커스텀_문자열_입력_테스트`() {
        assertSimpleTest {
            val input = "//;\\n10;50;20"
            val res = listOf("10", "50", "20")
            assertThat(calculatorService.customParseInput(input)).isEqualTo(res)
        }
    }

    @Test
    fun `커스텀_문자열_구분자_미입력_테스트`() {
        assertSimpleTest {
            val input = "//\\n50"
            assertThrows<IllegalArgumentException> { calculatorService.customParseInput(input) }
        }
    }

    @Test
    fun `커스텀_문자열_구분자_길이_테스트`() {
        assertSimpleTest {
            val input = "//>;\\n100>;50"
            assertThrows<IllegalArgumentException> { calculatorService.customParseInput(input) }
        }
    }
}