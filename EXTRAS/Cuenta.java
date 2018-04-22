


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Cuenta{
   
    String iban;
    Set<String> clientes;
    BigDecimal saldo;

    Cuenta(String iban){
        
        this.iban = iban;
        clientes=new HashSet<>();
        this.saldo= new BigDecimal("0.00");
    }

    
   public void ingresar (BigDecimal cantidad) throws Exception {
        if (cantidad.compareTo(BigDecimal.ZERO) >0) {
            saldo=saldo.add(cantidad);
        }
        else {
            throw new MovimientoException(iban,cantidad,"Cantidad de ingreso no válida.");
        }
    }
    
    
    public void retirar (BigDecimal cantidad) throws Exception {
        if (cantidad.compareTo(BigDecimal.ZERO) >0) {
            throw new MovimientoException(iban,cantidad,"Cantidad de reintegro no v�lida.");        
        }
        if (saldo.compareTo(cantidad)>= 0) { // Si el saldo permite retirar esa cantidad
            saldo=saldo.subtract(cantidad);  // Se retira esa cantidad 
        }
        else {
            throw new MovimientoException(iban,cantidad,"Saldo insuficiente.");        
        }
    }
  
}
