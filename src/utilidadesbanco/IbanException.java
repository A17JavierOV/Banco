package utilidadesbanco;
public class IbanException extends Exception{
    String iban;
    public IbanException(String iban,String mensaje){
        super(mensaje);
        this.iban=iban;
    }
    public String getIban(){
        return iban;
    }
}