import java.util.HashSet;
import java.util.Set;
class Cliente {
    String dni;
    String nombre;
    Set<String> cuentas= new HashSet<>();
    
    public Cliente(String dni,String nombre){
           this.dni=dni;
           this.nombre=nombre;
    }
}
