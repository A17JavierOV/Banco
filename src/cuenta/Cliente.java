package cuenta;

import dni.DNI;
import dni.DNIException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*******************************************************************************
 * @author A17JavierOV
 ******************************************************************************/

public class Cliente {
    
    String dni;
    String nombre;
    Set<Cuenta> cuentas= new HashSet<>();
    
    /***************************************************************************
     *
     * @param dni String
     * @param nombre String
     * 
     * Esta clase comprueba que el DNI insertado sea correcto y almacena en una
     * clase Cliente el DNI, el NOMBRE y las CUENTAS asociadas a ese cliente.
     * Abajo tenemos primero de todo el constructor, que automáticamente comprueba
     * el DNI y, si es correcto, crea el Cliente.
     * 
     ***************************************************************************/
    public Cliente(String dni,String nombre){
        
        try{
            String numdni;
            char letdni;
            DNI documento = new DNI(dni);
            numdni = documento.getDNISoloNumero();
            letdni = documento.getDNISoloLetra();
            if(letdni == DNI.calcularLetra(numdni)){
                this.dni = dni;
                this.nombre = nombre;
            }else{
                System.out.println("El DNI insertado no es correcto.");
            }
        }catch(DNIException dniex){
            System.out.println("DNI no válido");
        }
    }
    
    @Override
    public boolean equals(Object o) {
      if (o instanceof Cliente) {
        Cliente p = (Cliente)o;
        return this.dni.equals(p.dni);
      } else {
        return false;
      }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.dni);
        return hash;
    }
    
    /***************************************************************************
     * @param iban
     * 
     * agregarCuenta(Cuenta iban) Es el método que añade las cuentas al hashSet
     * asociado a cada objeto Cliente.
     ***************************************************************************/
    public void agregarCuenta(Cuenta iban){
        cuentas.add(iban);
    }
    
    /***************************************************************************
     * @param iban
     * 
     * borrarCuenta(Cuenta iban) Borra del hashSet la cuenta seleccionada asociada
     * al cliente elegido.
     ***************************************************************************/
    public void borrarCuenta(Cuenta iban){
        cuentas.remove(iban);
    }
    
    
}
