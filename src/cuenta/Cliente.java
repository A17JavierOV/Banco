package cuenta;

import dni.DNI;
import dni.DNIException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cliente {
    
    String dni;
    String nombre;
    Set<Cuenta> cuentas= new HashSet<>();
    
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
    
    public void agregarCuenta(Cuenta iban){
        cuentas.add(iban);
    }
    
    public void borrarCuenta(Cuenta iban){
        cuentas.remove(iban);
    }
}
