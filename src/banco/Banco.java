/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author a17javierov
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("GESTION BANCO");
        System.out.println("[1]. Utilidades banco");
        System.out.println("[2]. Creación cuenta");
        System.out.println("[0]. Salir");
        
        System.out.println("Seleccionar una opción: ");
        
        System.out.println("UTILIDADES BANCO");
        System.out.println("[1]. Calcular CCC");
        System.out.println("[2]. Calcular IBAN");
        System.out.println("[0]. Salir");
        
        System.out.println("Seleccionar una opción: ");
        
        System.out.println("Introduzca los datos: ");
        System.out.println("Entidad: ");
        System.out.println("Oficina: ");
        System.out.println("Cliente: ");
        System.out.println("Su CCC: " + utilidadesbanco.UtilidadesBanco.calcular_CCC(entidad, oficina, cliente));
        
        
    }
    
}
