package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `커스텀 구분자 사용`() {
        assertSimpleTest {
            run("//;\\n1")
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `오버_플로우_테스트`() {
        assertSimpleTest {
            run("2147483647,1")
            assertThat(output()).contains("결과 : 2147483648")
        }
    }

    @Test
    fun `큰수_테스트`() {
        assertSimpleTest {
            run("10000000000,1000000,10000000000000")
            assertThat(output()).contains("결과 : 10010001000000")
        }
    }

    override fun runMain() {
        main()
    }
}
