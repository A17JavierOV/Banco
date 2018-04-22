package banco;
import java.util.Scanner;
import cuenta.*;
import utilidadesbanco.*;

public class Banco {

    public static void main(String[] args) {
        
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

                System.out.println("UTILIDADES BANCO");
                System.out.println("[1]. Calcular CCC");
                System.out.println("[2]. Calcular IBAN");
                System.out.println("[0]. Salir");

                System.out.println("Seleccionar una opción: ");
                opcion = sc.nextInt();

            }else if(opcion==2){
                
                String entidad, oficina, cliente;

                System.out.println("Introduzca los datos: ");
                System.out.println("Entidad: ");
                entidad = sc.nextLine();
                System.out.println("Oficina: ");
                oficina = sc.nextLine();
                System.out.println("Cliente: ");
                cliente = sc.nextLine();
                System.out.println("Su CCC: " + utilidadesbanco.UtilidadesBanco.calcular_CCC(entidad, oficina, cliente));

            }else{

            }
        }
    }
}