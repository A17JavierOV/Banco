package utilidadesbanco;

import java.math.BigInteger;

public class UtilidadesBanco {
    
    public static  void validarCCC(String ccc) throws CCCException {
        String entidad, oficina,  dc, cliente;
        if(ccc.length()!=20)
            throw new CCCException(ccc,"longitud de ccc incorrecta");
        entidad=ccc.substring(0, 4);
        oficina=ccc.substring(4, 8);
        dc=ccc.substring(8,10);
        cliente=ccc.substring(10,20);
        
        String dcCalculado;
        dcCalculado=calcularDC_ccc(entidad, oficina, cliente);
        if(!dc.equals(dcCalculado))
            throw new CCCException(ccc,"error detectado por DC de CCC");
        
    }
    
    public static String calcular_CCC(String entidad,  String oficina,  String cliente) throws CCCException{
        validarCCC(entidad+oficina+calcularDC_ccc(entidad,oficina,cliente)+ cliente);
        return entidad+oficina+calcularDC_ccc(entidad,oficina,cliente)+ cliente ;
        
    }
    
    public static String calcularDC_ccc( String entidad,  String oficina,  String cliente){
        String primeraCifraDC,segundaCifraDC;
        primeraCifraDC=calcular1DC("00"+entidad+oficina);
        segundaCifraDC=calcular1DC(cliente);
        return primeraCifraDC+segundaCifraDC;
    }
    
    private static String calcular1DC (String codigo){
        String dc="";
        
        // Comprobación de que los parámetros son válidos por si acaso
        if (codigo == null || codigo.length() != 10 ) {
            return dc;
        }
        
        // Algoritmo de cálculo de 1 dígito de control para un código de 10 cifras
        int n;
        int suma=0;
        for (n=0; n<10; n++) {
            int factor, cifra;
            factor= ((int)(Math.pow(2, n))) % 11;
            cifra= Integer.parseInt(codigo.substring(n, n+1));
            suma +=  cifra * factor;
        }
        suma= suma % 11;
        suma= 11 - suma;
        if (suma == 10)
            suma= 1;
        else if (suma == 11)
            suma= 0;
        
        // Se devuelve el DC calculado en forma de String
        dc= String.valueOf(suma);
        return dc;
    }
    
    public static void validarIBAN(String iban) throws IbanException, CCCException{
        //suponemos para simplificar iban españa que siempre son 4 + 20 dígitos
        if(iban.length()!=24)
            throw new IbanException(iban,"longitud de iban incorrecta");
        String ibanCalculado=calcular_iban(iban.substring(0,2),iban.substring(4));
        if(!iban.equals(ibanCalculado)){
            throw new IbanException(iban,"erro detectado por dc iban");
        }
    }
    
    public static String calcular_iban(String pais, String ccc) throws CCCException{
        validarCCC(ccc);
        return pais+calcularDC_iban(pais,ccc)+ccc;
        
    }
    
    public static String calcularDC_iban(String pais, String ccc) throws CCCException{
        //suponemos que ccc es OK
        /* podemos comprobar  la tabla de letras de pais
            for(char c ='A';c<='Z';c++){
            System.out.println(c+ "en tabla IBAN "+ ((int)c-55));
        }
        por tanto con (int)c-55 obtenemos el número de la tabla
        */
        int numero1=(int)(pais.charAt(0))-55;
        int numero2=(int)(pais.charAt(1))-55;
        String sParaCalcularDC=ccc+String.valueOf(numero1)+String.valueOf(numero2)+"00";
        BigInteger biParaCalcularDC= new BigInteger(sParaCalcularDC);
        BigInteger resto=biParaCalcularDC.mod(new BigInteger("97"));
        int restoInt=resto.intValue();
        int dcInt=98-restoInt;
        String dc=(dcInt<10)?"0"+dcInt:""+dcInt;
        return dc;
    }
    
}


