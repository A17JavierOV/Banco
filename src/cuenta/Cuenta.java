package cuenta;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import utilidadesbanco.CCCException;
import static utilidadesbanco.UtilidadesBanco.calcular_iban;

/*******************************************************************************
 * @author A17JavierOV
 *******************************************************************************/
public class Cuenta {

    String iban, ccc;
    HashSet<Cliente> clientes;
    BigDecimal saldo;

    Cuenta(String iban){
        
        this.iban = iban;
        clientes=new HashSet<>();
        this.saldo= new BigDecimal("0.00");
    }
    
    public Cuenta(String entidad, String oficina, String cliente, Cliente datosCliente) {

        String ccc, iban;
        
        try{
            ccc = utilidadesbanco.UtilidadesBanco.calcular_CCC(entidad, oficina, cliente);
            iban = calcular_iban("ES", ccc);
            this.iban = iban;
            this.ccc = ccc;
            this.clientes = new HashSet<>();
            clientes.add(datosCliente);
        }catch(CCCException cccex){
            System.out.println("Datos de cuenta no válidos.");
        }     
    }
    
    public String getIban() {
        return iban;
    }

    public String getCcc() {
        return ccc;
    }
    
    /***************************************************************************
     * @param cantidad
     * @throws Exception
     * 
     * Ingresa una cantidad asociada a un objeto Cuenta
     ***************************************************************************/
    public void ingresar (BigDecimal cantidad) throws Exception {
        if (cantidad.compareTo(BigDecimal.ZERO) >0) {
            saldo=saldo.add(cantidad);
        }
        else {
            throw new MovimientoException(iban,cantidad,"Cantidad de ingreso no válida.");
        }
    }
    
    /***************************************************************************
     * @param cantidad
     * @throws Exception
     * 
     * Resta una cantidad del saldo que tenga la Cuenta.
     ***************************************************************************/
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
        
    @Override
    public boolean equals(Object o) {
      if (o instanceof Cuenta) {
        Cuenta p = (Cuenta)o;
        return this.iban.equals(p.iban);
      } else {
        return false;
      }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.iban);
        return hash;
    }
    
    /***************************************************************************
     * @param dni
     * 
     * Agrega un objeto Cliente al hashSet de la Cuenta, por si hay varios
     * titulares en la Cuenta establecida.
     ***************************************************************************/
    public void agregarCliente(Cliente dni){
        clientes.add(dni);
    }
    
    /***************************************************************************
     * @param dni
     * 
     * Borra Clientes contenidos en el hashSet asociado a una Cuenta en concreto.
     ***************************************************************************/
    public void borrarCliente(Cliente dni){
        clientes.remove(dni);
    }
}
