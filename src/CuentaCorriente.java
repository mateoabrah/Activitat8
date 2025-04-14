import java.math.BigDecimal;  // Importamos la clase BigDecimal para manejar decimales de manera precisa.
import java.math.RoundingMode; // Importamos RoundingMode para controlar cómo redondeamos los números.

public class CuentaCorriente {
    private BigDecimal saldo; // Atributo que representa el saldo de la cuenta, usando BigDecimal para manejar decimales con precisión.

    // Constructor que inicializa la cuenta con saldo 0.00 y establece la escala a 2 decimales (usando RoundingMode.HALF_UP para redondear).
    public CuentaCorriente() {
        this.saldo = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    }

    // Método getter para obtener el saldo actual de la cuenta.
    public BigDecimal getSaldo() {
        return saldo;
    }
    
    // Método para ingresar una cantidad de dinero en la cuenta. Solo se permite si la cantidad es positiva y no mayor a 6000.00.
    public void ingresar(BigDecimal cantidad) {
    	
        // Verificamos que la cantidad sea mayor que 0 y no mayor a 6000.00.
        if (cantidad.compareTo(BigDecimal.ZERO) > 0 && cantidad.compareTo(new BigDecimal("6000.00")) <= 0) {
        	
            // Si la cantidad es válida, se agrega al saldo de la cuenta, redondeando a 2 decimales.
            this.saldo = this.saldo.add(cantidad.setScale(2, RoundingMode.HALF_UP));
        }
    }
    
    // Método para retirar dinero de la cuenta. Solo se permite si la cantidad es positiva, no supera el saldo disponible y no es mayor a 6000.00.
    public void retirar(BigDecimal cantidad) {
    	
        // Verificamos que la cantidad sea mayor que 0, no mayor al saldo actual y no mayor a 6000.00.
        if (cantidad.compareTo(BigDecimal.ZERO) > 0 && cantidad.compareTo(saldo) <= 0 && cantidad.compareTo(new BigDecimal("6000.00")) <= 0) {
        	
            // Si la cantidad es válida, se resta del saldo, redondeando a 2 decimales.
            this.saldo = this.saldo.subtract(cantidad.setScale(2, RoundingMode.HALF_UP));
        }
    }

    // Método para transferir dinero desde esta cuenta a otra cuenta. Solo se permite si la cantidad es positiva, no supera el saldo disponible y no es mayor a 3000.00.
    public void transferir(CuentaCorriente destino, BigDecimal cantidad) {
    	
        // Verificamos que la cantidad sea mayor que 0, no mayor al saldo y no mayor a 3000.00.
        if (cantidad.compareTo(BigDecimal.ZERO) > 0 && cantidad.compareTo(this.saldo) <= 0 && cantidad.compareTo(new BigDecimal("3000.00")) <= 0) {
        	
            // Si la cantidad es válida, se resta del saldo de esta cuenta y se agrega al saldo de la cuenta destino.
            this.saldo = this.saldo.subtract(cantidad.setScale(2, RoundingMode.HALF_UP));
            destino.ingresar(cantidad); // Llamamos al método ingresar de la cuenta destino.
        }
    }
}

