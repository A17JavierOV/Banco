package utilidadesbanco;
public class CCCException extends Exception{
    
    String ccc;
    
    public CCCException(String ccc,String mensaje){
        super(mensaje);
        this.ccc=ccc;
    }
    
    public String getCCC(){
        return ccc;
    }
}
