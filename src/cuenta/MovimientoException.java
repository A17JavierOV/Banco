package cuenta;

import java.math.BigDecimal;

public class MovimientoException extends  Exception{
    
    String  ccc;
    BigDecimal cantidad;
    String mensaje;
    
    public MovimientoException(String ccc, BigDecimal cantidad, String mensaje){
        super(mensaje);
        this.ccc=ccc;
        this.cantidad=cantidad;
        this.mensaje=mensaje;
    }
    public String getCcc(){
        return ccc;
    }
    public BigDecimal getCantidad(){
        return cantidad;
    }
    public String getMensaje(){
        return mensaje;
    }
    
}
