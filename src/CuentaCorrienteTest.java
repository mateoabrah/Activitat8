import org.junit.jupiter.api.Test; // Importamos las clases necesarias para las pruebas.
import static org.junit.jupiter.api.Assertions.*; // Importamos los métodos de aserción para las pruebas.
import java.math.BigDecimal; // Importamos BigDecimal para manejar los valores decimales.

public class CuentaCorrienteTest {

    // Test para verificar que la cuenta se crea con saldo cero.
    @Test
    public void testCuentaSeCreaConSaldoCero() {
        CuentaCorriente cuenta = new CuentaCorriente(); // Creamos una nueva cuenta.
        assertEquals(BigDecimal.ZERO, cuenta.getSaldo()); // Verificamos que el saldo sea cero.
    }
    
    // Test para verificar que el ingreso de una cantidad en una cuenta vacía aumenta el saldo correctamente.
    @Test
    public void testIngresoSaldoInicialCero() {
        CuentaCorriente cuenta = new CuentaCorriente(); // Creamos una nueva cuenta.
        cuenta.ingresar(new BigDecimal("100.00")); // Ingresamos 100.
        assertEquals(new BigDecimal("100.00"), cuenta.getSaldo()); // Verificamos que el saldo sea 100.
    }

    // Test para verificar que no se pueden ingresar cantidades negativas.
    @Test
    public void testIngresoNegativoNoCambiaSaldo() {
        CuentaCorriente cuenta = new CuentaCorriente(); // Creamos una nueva cuenta.
        cuenta.ingresar(new BigDecimal("-100.00")); // Intentamos ingresar una cantidad negativa.
        assertEquals(BigDecimal.ZERO, cuenta.getSaldo()); // Verificamos que el saldo sigue siendo cero.
    }

    // Test para verificar que no se puede ingresar más de 6000.00 en una cuenta.
    @Test
    public void testIngresoMayorQue6000NoSeRealiza() {
        CuentaCorriente cuenta = new CuentaCorriente(); // Creamos una nueva cuenta.
        cuenta.ingresar(new BigDecimal("6000.01")); // Intentamos ingresar una cantidad mayor a 6000.00.
        assertEquals(BigDecimal.ZERO, cuenta.getSaldo()); // Verificamos que el saldo sigue siendo cero.
    }
    
    // Test para verificar que una retirada reduce el saldo correctamente si hay suficiente dinero.
    @Test
    public void testRetiroSaldoSuficiente() {
        CuentaCorriente cuenta = new CuentaCorriente(); // Creamos una nueva cuenta.
        cuenta.ingresar(new BigDecimal("500.00")); // Ingresamos 500.
        cuenta.retirar(new BigDecimal("100.00")); // Retiramos 100.
        assertEquals(new BigDecimal("400.00"), cuenta.getSaldo()); // Verificamos que el saldo es 400.
    }

    // Test para verificar que si no hay suficiente saldo, la retirada no cambia el saldo.
    @Test
    public void testRetiroSaldoInsuficienteNoCambiaSaldo() {
        CuentaCorriente cuenta = new CuentaCorriente(); // Creamos una nueva cuenta.
        cuenta.ingresar(new BigDecimal("200.00")); // Ingresamos 200.
        cuenta.retirar(new BigDecimal("500.00")); // Intentamos retirar 500 (más de lo disponible).
        assertEquals(new BigDecimal("200.00"), cuenta.getSaldo()); // Verificamos que el saldo sigue siendo 200.
    }

    // Test para verificar que una transferencia exitosa actualiza ambos saldos correctamente.
    @Test
    public void testTransferenciaExitosa() {
        CuentaCorriente cuentaOrigen = new CuentaCorriente(); // Creamos una cuenta de origen.
        CuentaCorriente cuentaDestino = new CuentaCorriente(); // Creamos una cuenta destino.
        cuentaOrigen.ingresar(new BigDecimal("500.00")); // Ingresamos 500 en la cuenta origen.
        cuentaOrigen.transferir(cuentaDestino, new BigDecimal("100.00")); // Transferimos 100 a la cuenta destino.
        assertEquals(new BigDecimal("400.00"), cuentaOrigen.getSaldo()); // Verificamos que la cuenta origen tenga 400.
        assertEquals(new BigDecimal("100.00"), cuentaDestino.getSaldo()); // Verificamos que la cuenta destino tenga 100.
    }

    // Test para verificar que una transferencia negativa no cambia nada.
    @Test
    public void testTransferenciaNegativaNoSeRealiza() {
        CuentaCorriente cuentaOrigen = new CuentaCorriente(); // Creamos una cuenta de origen.
        CuentaCorriente cuentaDestino = new CuentaCorriente(); // Creamos una cuenta destino.
        cuentaOrigen.ingresar(new BigDecimal("500.00")); // Ingresamos 500 en la cuenta origen.
        cuentaOrigen.transferir(cuentaDestino, new BigDecimal("-100.00")); // Intentamos transferir una cantidad negativa.
        assertEquals(new BigDecimal("500.00"), cuentaOrigen.getSaldo()); // Verificamos que la cuenta origen no cambia.
        assertEquals(BigDecimal.ZERO, cuentaDestino.getSaldo()); // Verificamos que la cuenta destino sigue siendo cero.
    }
}
