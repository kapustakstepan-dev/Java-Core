import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculadoraTest {

    @Test
    fun sumarDosNumeros() {
        val resultado = 2 + 3
        assertEquals(5, resultado)
    }
}