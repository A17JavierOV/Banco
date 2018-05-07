package banco;
import java.util.Scanner;
import cuenta.*;
import utilidadesbanco.*;
import static utilidadesbanco.UtilidadesBanco.validarCCC;
import static utilidadesbanco.UtilidadesBanco.validarIBAN;

public class Banco {

    public static void main(String[] args) throws CCCException {
        
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        
        System.out.println("GESTION BANCO");
        System.out.println("[1]. Utilidades banco");
        System.out.println("[2]. Creación cuenta");
        System.out.println("[0]. Salir");

        System.out.println("Seleccionar una opción: ");
        opcion = sc.nextInt();

        while(opcion!=0){
            
            if(opcion==1){
                
                int seleccion;

                System.out.println("UTILIDADES BANCO");
                System.out.println("[1]. Calcular CCC");
                System.out.println("[2]. Calcular IBAN");
                System.out.println("[0]. Salir");

                System.out.println("Seleccionar una opción: ");
                seleccion = sc.nextInt();
                
                while(seleccion!=0){
                
                    if(seleccion==1){
                        String ccc;
                        System.out.println("Inserte CCC: ");
                        ccc = sc.next();
                        try{ 
                            validarCCC(ccc);
                            System.out.println("CCC válido.");
                            break;
                        }catch(CCCException ex){
                            System.out.println(ex.getMessage());
                        }
                    }else if(seleccion==2){
                        String iban;
                        System.out.println("Inserte IBAN: ");
                        iban = sc.next();
                        try{ 
                            validarIBAN(iban);
                            System.out.println("IBAN válido.");
                            break;
                        }catch(IbanException ibanex){
                            System.out.println("El IBAN que estás intentando insertar no es válido.");
                        }

                    }else if(seleccion==0){
                        System.out.println("Gracias por usar nuestros servicios.");
                    }
                }

            }else if(opcion==2){
                
                try {
                    String dni, nombre, entidad, oficina, cliente;
                                        
                    System.out.println("Introduzca los datos: ");
                    System.out.println("Nombre del titular: ");
                    nombre = sc.next();
                    System.out.println("DNI del titular: ");
                    dni = sc.next();
                    Cliente datosCliente = new Cliente(dni, nombre);
                    System.out.println("Entidad: ");
                    entidad = sc.next();
                    System.out.println("Oficina: ");
                    oficina = sc.next();
                    System.out.println("Número de cuenta cliente: ");
                    cliente = sc.next();
                    System.out.println("Su CCC: " + utilidadesbanco.UtilidadesBanco.calcular_CCC(entidad, oficina, cliente));
                } catch (CCCException ex) {
                    System.out.println("El valor que estás intentando introducir no es válido");
                }
            }else{
                System.out.println("Gracias por usar nuestros servicios.");
                break;
            }
        }
    }
}